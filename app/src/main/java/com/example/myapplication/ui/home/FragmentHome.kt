package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CardsAdapter
import com.example.myapplication.R
import com.example.myapplication.model.ProductCard


class FragmentHome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val promotionList: RecyclerView = view.findViewById(R.id.cart_recycler)

        val promotions = arrayListOf<ProductCard>()

        promotions.add(ProductCard(1,"Корм", "Путь до картинки", 100 ,1))
        promotions.add(ProductCard(2,"Корм2", "Путь до картинки", 120 ,1 ))
        promotions.add(ProductCard(3,"Корм3", "Путь до картинки", 130,1 ))
        promotions.add(ProductCard(4,"Корм4", "Путь до картинки", 140, 1))


        promotionList.layoutManager = GridLayoutManager(context,2)
        promotionList.adapter = context?.let { CardsAdapter(promotions, it) }


        val popularList: RecyclerView = view.findViewById(R.id.popularProductsRecycler)

        val popular = arrayListOf<ProductCard>()

        popular.add(ProductCard(5,"Товар1", "Путь до картинки", 2000, 1))
        popular.add(ProductCard(6,"Товар2Товар2Товар2", "Путь до картинки", 1220, 1))
        popular.add(ProductCard(7,"Товар2Товар2Товар3", "Путь до картинки", 1310, 1))
        popular.add(ProductCard(8,"4", "Путь до картинки", 3140, 1))

        popularList.layoutManager = GridLayoutManager(context,2)
        popularList.adapter = context?.let { CardsAdapter(popular, it) }

        val button = view.findViewById<Button>(R.id.showAllHomeButton1)

        // Установка слушателя нажатия на кнопку
        button.setOnClickListener {
            // Создание экземпляра фрагмента, на который нужно перейти
            val newFragment = FragmentHomePromotions()

            // Получение менеджера фрагментов
            val fragmentManager = requireActivity().supportFragmentManager

            // Начало транзакции фрагментов
            val transaction = fragmentManager.beginTransaction()

            // Замена текущего фрагмента на новый
            transaction.replace(R.id.home_layout, newFragment)

            // Добавление транзакции в стек возврата
            transaction.addToBackStack(null)

            // Подтверждение транзакции
            transaction.commit()
        }



        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



    companion object {
        @JvmStatic
        fun newInstance() = FragmentHome()
    }
}