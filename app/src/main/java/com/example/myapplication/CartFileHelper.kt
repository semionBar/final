package com.example.myapplication

import android.content.Context
import android.widget.Toast
import com.example.myapplication.model.ProductCard
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class CartFileHelper () {

    fun writeToCsv(file: String, productCard: ProductCard, context: Context) {

        var data = "${productCard.id}, \"${productCard.title}\", \"${productCard.image}\", ${productCard.price}, 1\n"

        var productCards = readCsv(file, context)

        if (productCards.any { it.id == productCard.id }) {
            //если такой товар уже имеется, то прибавить 1
            val index = productCards.find {it.id == productCard.id}
            index?.amount = index?.amount!! + 1

            data = ""
            for (card in productCards) {
                data += "${card.id}, \"${card.title}\", \"${card.image}\", ${card.price}, ${card.amount}\n"
            }
            try {
                val fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                val f = File(context.filesDir, file)
                f.createNewFile()
                val fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        else {
            try {
                val fileOutputStream = context.openFileOutput(file, Context.MODE_APPEND)
                fileOutputStream.write(data.toByteArray())
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                val f = File(context.filesDir, file)
                f.createNewFile()
                val fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun removeFromCsv (file: String, card: ProductCard, context: Context) {
        val productCards = readCsv(file, context)
        val newProductCards: List<ProductCard>

        if (productCards.any { it.id == card.id }) {
            val productCard = productCards.find { it.id == card.id }
            if (productCard != null) {
                if (productCard.amount == 1) {
                    newProductCards = productCards.filter { it.id != productCard.id }
                    rewriteCsv(file, context, newProductCards)
                }
                else {
                    productCard.amount--
                    rewriteCsv(file, context, productCards)
                }
            }
        }
    }

    fun rewriteCsv (file: String, context: Context, productCards: List<ProductCard>) {

        var data: String = ""

        for (card in productCards) {
            data += "${card.id}, \"${card.title}\", \"${card.image}\", ${card.price}, ${card.amount}\n"
        }
        try {
            val fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            val f = File(context.filesDir, file)
            f.createNewFile()
            val fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun clearCsv(file: String, context: Context) {
        val data = ""

        readCsv(file,context)

        try {
            val fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            val f = File(context.filesDir, file)
            f.createNewFile()
            val fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())

        } catch (e: NumberFormatException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        Toast.makeText(context,"data save", Toast.LENGTH_LONG).show()
    }

    fun deleteCsv(file: String, context: Context) {
        val f = File(context.filesDir, file)
        if (f.exists()) {
            f.delete()
        }
    }

    fun readCsv(file: String, context: Context) : List<ProductCard> {
        try {
            val inputStream = context.openFileInput(file)

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            val f = File(context.filesDir, file)
            f.createNewFile()
        }
        val inputStream = context.openFileInput(file)
        val reader = inputStream.bufferedReader()
        return reader.lineSequence()
            .filter { it.isNotBlank() }
            .map {
                val (id, tittle, image, price, amount) = it.split(',', ignoreCase = false, limit = 5)
                ProductCard(id.trim().toInt() ,tittle.trim().removeSurrounding("\""), image.trim().removeSurrounding("\""), price.trim().toInt(), amount.trim().toInt())
            }.toList()

    }
}