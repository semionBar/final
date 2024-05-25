package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.cart.FragmentCart
import com.example.myapplication.ui.cart.FragmentCartEmpty
import com.example.myapplication.ui.home.FragmentHome
import com.example.myapplication.ui.login.LoginActivity


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


        // Выбрать самый первый таб в нижнем меню
        binding.bottomNav.selectedItemId = R.id.bottom_menu_home
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_layout, FragmentHome())
            .commit()

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.bottom_menu_home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.home_layout, FragmentHome())
                        .commit()
                }
                R.id.bottom_menu_category -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.home_layout, FragmentCategory())
                        .commit()
                }
                R.id.bottom_menu_favorite -> {
                }
                R.id.bottom_menu_cart -> {

                    if (ArrayList(CartFileHelper().readCsv("cart.csv", this)).isNotEmpty()) {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.home_layout, FragmentCart())
                            .commit()
                    }
                    else {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.home_layout, FragmentCartEmpty())
                            .commit()
                    }
                }
                R.id.bottom_menu_person -> {
                }
            }
            true
        }
    }
}

