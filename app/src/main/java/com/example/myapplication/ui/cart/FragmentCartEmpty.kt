package com.example.myapplication.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.ui.home.FragmentHome

class FragmentCartEmpty : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart_empty, container,false)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentHome()
    }
}