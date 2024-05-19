package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CardsAdapter
import com.example.myapplication.R
import com.example.myapplication.model.ProductCard

class FragmentHomePromotions : Fragment() {

    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home_promotions, container, false)


        // Вывод товаров
        val promotionList: RecyclerView = view.findViewById(R.id.cartRecycler)

        val promotions = arrayListOf<ProductCard>().apply {


            add(ProductCard(9,"Корм", "Путь до картинки", 140, 1))
            add(ProductCard(10,"Корм2", "Путь до картинки", 11 , 1))
            add(ProductCard(11,"Корм5", "Путь до картинки", 120 , 1))
            add(ProductCard(12,"Корм12", "Путь до картинки", 130, 1))
            add(ProductCard(13,"Корм13", "Путь до картинки", 140 ,1))
            add(ProductCard(14,"Корм2345", "Путь до картинки", 140 ,1))
            add(ProductCard(15,"Корм412", "Путь до картинки", 140, 1))
            add(ProductCard(17,"Корм433", "Путь до картинки", 1235, 1))
            add(ProductCard(18,"Корм444", "Путь до картинки", 140, 1))
            add(ProductCard(19,"Корм455", "Путь до картинки", 140, 1))
            add(ProductCard(20,"Корм123", "Путь до картинки", 140, 1))
            add(ProductCard(21,"Корм222", "Путь до картинки", 140, 1))
        }

        //Вывод карточек
        promotionList.layoutManager = GridLayoutManager(context,2)
        //promotionList.adapter = context?.let { CardsAdapter(promotions, it) }

        // Выпадающий список сортировки
        spinner = view.findViewById(R.id.sortTypeSpinner)

        val listSortTypes = listOf("По возрастанию цены", "По убыванию цены")

        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listSortTypes)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if (position == 0) {
                    promotions.sortBy { it.price }
                    promotionList.adapter = context?.let { CardsAdapter(promotions, it) }
                }
                else {
                    promotions.sortByDescending { it.price }
                    promotionList.adapter = context?.let { CardsAdapter(promotions, it) }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val imageButton = view.findViewById<ImageButton>(R.id.imageButton)

        imageButton.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.popBackStack();
        }



        return view
    }



    companion object {
        @JvmStatic
        fun newInstance() = FragmentHome()
    }
}

