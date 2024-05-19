package com.example.myapplication.screen.cart

import android.view.View
import com.example.myapplication.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object CartScreen: KScreen<CartScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val cartTitle: KTextView = KTextView {withId(R.id.promotionHomeTittle)}
    val backButton: KButton = KButton {withId(R.id.imageButton)}
    val addressTitle: KTextView = KTextView {withId(R.id.AddressTextView)}

    val addressEditText: KEditText = KEditText {withId(R.id.editTextText)}

    val roomEditText: KEditText = KEditText {withId(R.id.roomEditText)}
    val floorEditText: KEditText = KEditText {withId(R.id.floorEditText)}
    val intercomEditText: KEditText = KEditText {withId(R.id.intercomTextText)}

    val continuePurchaseButton: KButton = KButton {withId(R.id.continuePurchaseButton)}

    val rvCartCards = KRecyclerView(
        builder = { withId(R.id.cartRecycler) },
        itemTypeBuilder = { itemType(::CartScreen) }
    )

    class CartScreen(matcher: Matcher<View>): KRecyclerItem<CartScreen>(matcher) {
        val price = KTextView(matcher) {withId(R.id.product_price)}
        val tittle = KTextView(matcher) {withId(R.id.product_title)}
        val plusButton = KButton(matcher) {withId(R.id.plus_button)}
        val minusButton = KButton(matcher) {withId(R.id.minus_button)}
        val amount = KTextView(matcher) { withId(R.id.product_amount) }
    }
}