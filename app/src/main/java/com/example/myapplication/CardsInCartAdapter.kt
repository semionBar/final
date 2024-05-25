package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.ProductCard


class CardsInCartAdapter(var cards: List<ProductCard>, var context: Context) : RecyclerView.Adapter<CardsInCartAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.product_image)
        val price: TextView = view.findViewById(R.id.product_price)
        val title: TextView = view.findViewById(R.id.product_title)
        val amount: TextView = view.findViewById(R.id.product_amount) // to do



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
    }

}