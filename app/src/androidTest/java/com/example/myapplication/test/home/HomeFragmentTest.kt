package com.example.myapplication.test.home

import com.example.myapplication.screen.home.HomeFragmentScreen
import com.example.myapplication.screen.home.HomePromotionsFragmentScreen
import com.example.myapplication.test.login.LoginActivityTest
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test

class HomeFragmentTest: TestCase() {

    @Test
    fun testShowAllButton1Click() {
        LoginActivityTest().testValidLogin()
        HomeFragmentScreen {
            showAllButton1.click()
        }
        HomePromotionsFragmentScreen{
            screenTittle.isVisible()
            backButton.isVisible()
        }
    }
}