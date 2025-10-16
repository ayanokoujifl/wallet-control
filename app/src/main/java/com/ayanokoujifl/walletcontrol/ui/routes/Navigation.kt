package com.ayanokoujifl.walletcontrol.ui.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ayanokoujifl.walletcontrol.ui.screens.Home
import com.ayanokoujifl.walletcontrol.ui.screens.Settings

@Composable
fun App(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            Home(modifier, navController)
        }
        composable(route = Screen.Settings.route) {
            Settings(modifier, navController)
        }
    }
}