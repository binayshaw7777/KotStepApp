package com.binayshaw7777.kotstepapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.binayshaw7777.kotstepapp.presentation.screens.Amazon
import com.binayshaw7777.kotstepapp.presentation.screens.Flipkart
import com.binayshaw7777.kotstepapp.presentation.screens.Groww
import com.binayshaw7777.kotstepapp.presentation.screens.Home
import com.binayshaw7777.kotstepapp.presentation.screens.INDMoney

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screen.HOME.name,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Screen.HOME.name) {
            Home { screenName ->
                navController.navigate(screenName)
            }
        }
        composable(Screen.FLIPKART.name) {
            Flipkart() {
                navController.popBackStack()
            }
        }
        composable(Screen.AMAZON.name) {
            Amazon() {
                navController.popBackStack()
            }
        }
        composable(Screen.GROWW.name) {
            Groww() {
                navController.popBackStack()
            }
        }
        composable(Screen.INDMONEY.name) {
            INDMoney {
                navController.popBackStack()
            }
        }
    }
}