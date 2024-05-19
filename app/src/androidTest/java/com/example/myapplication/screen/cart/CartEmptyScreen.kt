package com.example.myapplication.screen.cart

import com.example.myapplication.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView

object CartEmptyScreen: KScreen<CartEmptyScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val emptyCartHint: KTextView = KTextView {withId(R.id.emptyCartHintTextView)}

}