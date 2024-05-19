package com.example.myapplication.test.cart

import com.example.myapplication.screen.cart.CartEmptyScreen
import com.example.myapplication.screen.cart.CartPaymentScreen
import com.example.myapplication.screen.cart.CartScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test

class CartPaymentFragmentTest: TestCase() {
    @Test
    fun testCartPayment () {
        CartFragmentTest().testAddToEmptyCart()
        CartScreen {
            //нужно добавить заполнение полей
            continuePurchaseButton.click()
        }
        CartPaymentScreen {
            continuePurchaseButton.click()
        }
        CartEmptyScreen {
            emptyCartHint.isVisible()
            emptyCartHint.containsText("Корзина пуста. Добавьте товары и они будут отображены здесь!")
        }
    }
}