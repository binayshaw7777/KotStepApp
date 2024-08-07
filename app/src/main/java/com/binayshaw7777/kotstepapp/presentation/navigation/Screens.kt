package com.binayshaw7777.kotstepapp.presentation.navigation

sealed class Screens(val route: String) {
    data object HOME : Screens(Screen.HOME.name)
    data object FLIPKART : Screens(Screen.HOME.name)
    data object AMAZON : Screens(Screen.HOME.name)
    data object GROWW : Screens(Screen.HOME.name)
}

enum class Screen {
    HOME,
    FLIPKART,
    AMAZON,
    GROWW
}

enum class NavigationScreen {
    FLIPKART,
    AMAZON,
    GROWW
}