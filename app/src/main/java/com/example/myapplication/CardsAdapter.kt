package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.ProductCard
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException


class CardsAdapter(var cards: List<ProductCard>, var context: Context) : RecyclerView.Adapter<CardsAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.product_image)
        val price: TextView = view.findViewById(R.id.product_price)
        val title: TextView = view.findViewById(R.id.product_title)
        val button = view.findViewById<Button>(R.id.addToCartButton)

        fun addToCart(card: ProductCard) {

            button.setOnClickListener {

                if (button.text.equals("В корзину")) {
                    //listProductCard.add(ProductCard(listProductCard.count() + 1, this.title.text.toString(),"Текст картинки",this.price.text.toString().toInt(), 1))
                    button.text = "В корзине"

                    val helper: CartFileHelper = CartFileHelper()
                    helper.writeToCsv("cart.csv", card, context) //нужна доп логика, если уже есть такой товар, то увеличить amount на 1
                    button.setBackgroundColor(Color.parseColor("#3B2419"))


                } else if (button.text.equals("В корзине")) {
                    button.text = "В корзину"
                    button.setBackgroundColor(Color.parseColor("#EFA56F"))
                    //тут нужно сделать удаление из файла
                }
            }

        }

    }

    private fun writeToCsv(file: String, productCard: ProductCard) {
        var data = "1, \"123213\", \"Путь до 2345234\", 120, 2\n"

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
        Toast.makeText(context, "data save", Toast.LENGTH_LONG).show()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cards.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = cards[position].title
        holder.price.text = cards[position].price.toString() + "₽"
        holder.addToCart(cards[position])

    }
}
