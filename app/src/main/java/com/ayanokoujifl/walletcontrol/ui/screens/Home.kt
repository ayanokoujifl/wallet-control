package com.ayanokoujifl.walletcontrol.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ayanokoujifl.walletcontrol.ui.components.Header
import com.ayanokoujifl.walletcontrol.ui.routes.Screen

@Composable
fun Home(modifier: Modifier = Modifier,navController: NavController){
    Column(modifier){
        Header()
        Button(
            onClick = {
                navController.navigate(Screen.Settings.route)
            },
        ){
        Text("settings")
        }
    }
}