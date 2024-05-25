package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.ProductCard


class CardsInCartAdapter(var cards: MutableList<ProductCard>, var context: Context) : RecyclerView.Adapter<CardsInCartAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.product_image)
        val price: TextView = view.findViewById(R.id.product_price)
        val title: TextView = view.findViewById(R.id.product_title)
        val amount: TextView = view.findViewById(R.id.product_amount)

        val plusButton = view.findViewById<ImageButton>(R.id.plus_button)
        val minusButton = view.findViewById<ImageButton>(R.id.minus_button)

        fun addOneCard (card: ProductCard) {
            plusButton.setOnClickListener {
                val helper: CartFileHelper = CartFileHelper()
                helper.writeToCsv("cart.csv", card, context)
                val am = amount.text.toString().toInt() + 1
                amount.text = am.toString()
            }
        }
        fun removeOneCard (card: ProductCard) {
            minusButton.setOnClickListener {
                val helper: CartFileHelper = CartFileHelper()
                helper.removeFromCsv("cart.csv", card, context)
                var am = amount.text.toString().toInt()
                if (am == 1) {
                    val position = adapterPosition
                    cards.removeAt(position);
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, cards.size)
                }
                else {
                    am -= 1
                    amount.text = am.toString()
                }
            }
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_in_cart, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cards.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = cards[position].title
        holder.price.text = cards[position].price.toString() + "₽"
        holder.amount.text = cards[position].amount.toString()
        holder.addOneCard(cards[position])
        holder.removeOneCard(cards[position])
    }

}