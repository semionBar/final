package com.example.myapplication.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.CartFileHelper
import com.example.myapplication.R
import com.example.myapplication.ui.home.FragmentHome


class FragmentCartPayment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart_payment, container, false)

        //Достать из файла информацию о добавленных в корзину товарах
        var cartCards = ArrayList(CartFileHelper().readCsv("cart.csv", requireActivity()))

        val deliverySum = 150
        var orderSum = cartCards.sumOf { it.price * it.amount }

        view.findViewById<TextView>(R.id.orderSumTextView).text = "Сумма заказа: " + orderSum + "₽"

        view.findViewById<TextView>(R.id.deliverySumTextView).text = "Доставка: " + deliverySum + "₽"

        view.findViewById<TextView>(R.id.totalSumTextView).text = "Итого: " + (deliverySum + orderSum) + "₽"

        view.findViewById<Button>(R.id.addToCartButton).setOnClickListener {

            // Получение менеджера фрагментов
            val fragmentManager = requireActivity().supportFragmentManager

            // Начало транзакции фрагментов
            val transaction = fragmentManager.beginTransaction()

            // Замена текущего фрагмента на новый
            transaction.replace(R.id.home_layout, FragmentCartEmpty())

            // Добавление транзакции в стек возврата
            transaction.addToBackStack(null)

            // Подтверждение транзакции
            transaction.commit()

            CartFileHelper().deleteCsv("cart.csv",requireActivity())
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentHome()
    }
}