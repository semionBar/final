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

        try {
            val fileOutputStream = context.openFileOutput(file, Context.MODE_APPEND)
            fileOutputStream.write(data.toByteArray())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            val f = File(context.filesDir, file)
            f.createNewFile()
            val fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())

        } catch (e: NumberFormatException){
            e.printStackTrace()
        } catch (e: IOException){
            e.printStackTrace()
        } catch (e: Exception){
            e.printStackTrace()
        }
        Toast.makeText(context,"data save", Toast.LENGTH_LONG).show()
    }

    fun clearCsv(file: String, context: Context) {
        var data = ""

        try {
            val fileOutputStream = context.openFileOutput(file, Context.MODE_APPEND)
            fileOutputStream.write(data.toByteArray())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            val f = File(context.filesDir, file)
            f.createNewFile()
            val fileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())

        } catch (e: NumberFormatException){
            e.printStackTrace()
        } catch (e: IOException){
            e.printStackTrace()
        } catch (e: Exception){
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