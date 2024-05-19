package com.example.myapplication.test.home
import com.example.myapplication.screen.home.HomeFragmentScreen
import com.example.myapplication.screen.home.HomePromotionsFragmentScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test

class HomePromotionFragmentTest: TestCase() {

    @Test
    fun backButtonTest() {
        HomeFragmentTest().testShowAllButton1Click()
        HomePromotionsFragmentScreen {
            backButton.click()
        }
        HomeFragmentScreen {
            showAllButton1.isVisible()
            homeImage.isVisible()
        }
    }

}