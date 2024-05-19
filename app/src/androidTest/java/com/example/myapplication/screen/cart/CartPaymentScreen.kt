package com.example.myapplication.screen.cart

import com.example.myapplication.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton

object CartPaymentScreen: KScreen<CartPaymentScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null


    val continuePurchaseButton = KButton {withId(R.id.addToCartButton)}
}