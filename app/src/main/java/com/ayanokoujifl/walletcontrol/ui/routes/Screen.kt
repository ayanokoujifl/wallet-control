package com.ayanokoujifl.walletcontrol.ui.routes

sealed class Screen(val route: String){
    object Home : Screen("home_screen")
    object Settings:Screen("settings_screen")
}