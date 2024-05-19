package com.example.myapplication.screen

import com.example.myapplication.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton


object LoginScreen : KScreen<LoginScreen>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val loginInput: KEditText = KEditText { withId(R.id.username) }
    val passwordInput: KEditText = KEditText { withId(R.id.password) }
    val loginButton: KButton = KButton { withId(R.id.loginButton) }
}