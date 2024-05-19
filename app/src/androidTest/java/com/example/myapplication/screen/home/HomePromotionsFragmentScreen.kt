package com.example.myapplication.screen.home

import com.example.myapplication.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object HomePromotionsFragmentScreen: KScreen<HomePromotionsFragmentScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val screenTittle: KTextView = KTextView {withId(R.id.promotionHomeTittle)}
    val backButton: KButton = KButton {withId(R.id.imageButton)}
}