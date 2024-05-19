package com.example.myapplication.screen.home

import android.view.View
import com.example.myapplication.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object HomeFragmentScreen: KScreen<HomeFragmentScreen>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val showAllButton1: KButton = KButton { withId(R.id.showAllHomeButton1) }
    val homeImage: KImageView = KImageView { withId(R.id.logoHomeImage) }


    val rvCards = KRecyclerView(
        builder = { withId(R.id.cartRecycler) },
        itemTypeBuilder = { itemType(::HomeFragmentScreen) }
    )

    class HomeFragmentScreen(matcher: Matcher<View>): KRecyclerItem<HomeFragmentScreen>(matcher) {

        val button = KButton(matcher) {withId(R.id.addToCartButton)}
        val price = KTextView(matcher) {withId(R.id.product_price)}
        val tittle = KTextView(matcher) {withId(R.id.product_title)}


    }
}