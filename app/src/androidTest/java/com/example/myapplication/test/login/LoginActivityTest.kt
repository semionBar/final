package com.example.myapplication.test.login

import androidx.test.core.app.ActivityScenario
import com.example.myapplication.MainActivity
import com.example.myapplication.screen.LoginScreen
import com.example.myapplication.screen.MainActivityScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test

class LoginActivityTest: TestCase() {

    @Test
    fun isInputsAndButtonVisible() {
        LoginScreen {
            ActivityScenario.launch(MainActivity::class.java)
            loginInput.isVisible()
            passwordInput.isVisible()
            loginButton.isVisible()
        }
    }
    @Test
    fun testValidLogin() {
        LoginScreen {
            ActivityScenario.launch(MainActivity::class.java)
            loginInput.replaceText("userName")
            passwordInput.replaceText("12345678")
            loginButton.click()
        }
        MainActivityScreen {
            bottomNavigator.isVisible()
        }
    }
    @Test
    fun testInvalidLoginAndPassword() {
        ActivityScenario.launch(MainActivity::class.java)
        LoginScreen {
            loginInput.replaceText("1")
            passwordInput.replaceText("1")
            loginButton.isDisabled()
        }
    }
}