package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.ProductCard
import com.example.myapplication.ui.cart.FragmentCart
import com.example.myapplication.ui.cart.FragmentCartEmpty
import com.example.myapplication.ui.home.FragmentHome
import com.example.myapplication.ui.login.LoginActivity
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(
            this@MainActivity,
            LoginActivity::class.java
        )
        startActivity(intent)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNav.selectedItemId = R.id.bottom_menu_home



        supportFragmentManager.
        beginTransaction().replace(R.id.home_layout, FragmentHome())
            .commit()

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.bottom_menu_home -> {

                    supportFragmentManager.
                            beginTransaction().replace(R.id.home_layout, FragmentHome())
                                .commit()
                    Toast.makeText(this, "Главная", Toast.LENGTH_SHORT).show()
                }
                R.id.bottom_menu_category -> {
                    supportFragmentManager.
                    beginTransaction().
                    replace(R.id.home_layout, FragmentCategory()).
                    commit()

                    Toast.makeText(this, "Категории", Toast.LENGTH_SHORT).show()
                }
                R.id.bottom_menu_favorite -> {
                    Toast.makeText(this, "favorite", Toast.LENGTH_SHORT).show()
                }
                R.id.bottom_menu_cart -> {

                    if (ArrayList(CartFileHelper().readCsv("cart.csv", this)).count() != 0) {
                        supportFragmentManager.
                        beginTransaction().replace(R.id.home_layout, FragmentCart())
                            .commit()
                        Toast.makeText(this, "sdfgsdfg", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        supportFragmentManager.
                        beginTransaction().replace(R.id.home_layout, FragmentCartEmpty())
                            .commit()
                        Toast.makeText(this, "sdfgsdfg", Toast.LENGTH_SHORT).show()
                    }


                }
                R.id.bottom_menu_person -> {
                    Toast.makeText(this, "person", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
}

