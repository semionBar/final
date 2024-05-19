package com.example.myapplication.screen

import com.example.myapplication.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.bottomnav.KBottomNavigationView

object MainActivityScreen: KScreen<MainActivityScreen>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val bottomNavigator: KBottomNavigationView =  KBottomNavigationView { withId(R.id.bottomNav) }

}