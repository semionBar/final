package com.example.myapplication.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CardsInCartAdapter
import com.example.myapplication.CartFileHelper
import com.example.myapplication.R
import com.example.myapplication.ui.home.FragmentHome


class FragmentCart : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        //добавление карточек товаров
        val cartCardsList: RecyclerView = view.findViewById(R.id.cart_recycler)

        //cartCards.add(ProductCard(1,"Корм", "Путь tо картинки", 100 ,1))
        //cartCards.add(ProductCard(2,"Корм2", "Путь до картинки", 120 ,1 ))
        //cartCards.add(ProductCard(3,"Корм3", "Путь до картинки", 130,1))
        //cartCards.add(ProductCard(4,"Корм4", "Путь до картинки", 140, 1))

        var cartCards = ArrayList(CartFileHelper().readCsv("cart.csv", requireActivity()))

        cartCardsList.layoutManager = GridLayoutManager(context,2)
        cartCardsList.adapter = context?.let { CardsInCartAdapter(cartCards, it) }

        val deliverySum = 150
        var orderSum = cartCards.sumOf { it.price * it.amount }

        view.findViewById<TextView>(R.id.orderSumTextView).text = "Сумма заказа: " + orderSum + "₽"

        view.findViewById<TextView>(R.id.deliverySumTextView).text = "Доставка: " + deliverySum + "₽"

        view.findViewById<TextView>(R.id.totalSumTextView).text = "Итого: " + (deliverySum + orderSum) + "₽"

        view.findViewById<Button>(R.id.continuePurchaseButton).setOnClickListener {

            // Получение менеджера фрагментов
            val fragmentManager = requireActivity().supportFragmentManager

            // Начало транзакции фрагментов
            val transaction = fragmentManager.beginTransaction()

            // Замена текущего фрагмента на новый
            transaction.replace(R.id.home_layout, FragmentCartPayment())

            // Добавление транзакции в стек возврата
            transaction.addToBackStack(null)

            // Подтверждение транзакции
            transaction.commit()
        }
        return view
    }





    companion object {
        @JvmStatic
        fun newInstance() = FragmentHome()
    }



}