package com.example.myapplication.test.cart

import com.example.myapplication.CartFileHelper
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.screen.MainActivityScreen
import com.example.myapplication.screen.cart.CartScreen
import com.example.myapplication.screen.home.HomeFragmentScreen
import com.example.myapplication.test.login.LoginActivityTest
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Test

class CartFragmentTest: TestCase() {

    @Test
    fun testAddToEmptyCart() = before{
        CartFileHelper().clearCsv("cart.csv", MainActivity().baseContext)
    }.run {
        LoginActivityTest().testValidLogin()
        HomeFragmentScreen {
            Assert.assertEquals(4, rvCards.getSize())
            rvCards {
                childAt<HomeFragmentScreen.HomeFragmentScreen>(0) {
                    button.click()
                }

            }
        }
        MainActivityScreen {
            bottomNavigator.setSelectedItem(R.id.bottom_menu_cart)
        }
        CartScreen {
            cartTitle.isVisible()
            backButton.isVisible()
            addressTitle.isVisible()
            addressEditText.isVisible()
            roomEditText.isVisible()
            floorEditText.isVisible()
            intercomEditText.isVisible()
            continuePurchaseButton.isVisible()
        }
    }
}