package com.binayshaw7777.kotstepapp.presentation.navigation

sealed class Screens(val route: String) {
    data object HOME : Screens(Screen.HOME.name)
    data object FLIPKART : Screens(Screen.FLIPKART.name)
    data object AMAZON : Screens(Screen.AMAZON.name)
    data object GROWW : Screens(Screen.GROWW.name)
}

enum class Screen {
    HOME,
    FLIPKART,
    AMAZON,
    GROWW,
    INDMONEY
}

enum class NavigationScreen {
    FLIPKART,
    AMAZON,
    GROWW,
    INDMONEY
}