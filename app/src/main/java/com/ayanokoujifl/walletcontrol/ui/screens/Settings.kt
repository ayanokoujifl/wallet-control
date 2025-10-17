package com.ayanokoujifl.walletcontrol.ui.screens;

import ThemeSwitcher
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun Settings(
    modifier: Modifier = Modifier,
    navController: NavController,
    isDarkTheme: Boolean,
    setTheme: () -> Unit
) {


    Column(modifier) {
        Row {
            Text("Change theme")
            ThemeSwitcher(darkTheme = isDarkTheme, onToggle = { setTheme() })
        }

        Button(onClick = { navController.popBackStack() }) {
            Text("Back")

        }
    }
}