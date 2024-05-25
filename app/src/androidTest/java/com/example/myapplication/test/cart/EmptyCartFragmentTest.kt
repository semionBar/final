package com.example.myapplication.test.cart


import com.example.myapplication.CartFileHelper
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.screen.MainActivityScreen
import com.example.myapplication.screen.cart.CartEmptyScreen
import com.example.myapplication.test.login.LoginActivityTest
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test

class EmptyCartFragmentTest: TestCase() {
    @Test
    fun testEmptyCartAfterLogin() = before {
        LoginActivityTest().testValidLogin()
        CartFileHelper().clearCsv("cart.csv", MainActivity().baseContext)
    }.run {
        LoginActivityTest().testValidLogin()
        MainActivityScreen {
            bottomNavigator.setSelectedItem(R.id.bottom_menu_cart)
        }
        CartEmptyScreen {
            emptyCartHint.isVisible()
            emptyCartHint.containsText("Корзина пуста. Добавьте товары, и они будут отображены здесь!")
        }
    }
}

