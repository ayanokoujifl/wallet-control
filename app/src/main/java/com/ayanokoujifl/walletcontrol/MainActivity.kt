package com.ayanokoujifl.walletcontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ayanokoujifl.walletcontrol.ui.routes.App
import com.ayanokoujifl.walletcontrol.ui.theme.WalletControlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            var isDark by remember { mutableStateOf(false) }
            fun setIsDark() {
                isDark = !isDark
            }
            WalletControlTheme(isDark, dynamicColor = false) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                ) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding),
                        isDarkTheme = isDark,
                        setTheme = { setIsDark() })
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("HELLO WALLET", color = Color(0xffffffff))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WalletControlTheme {
        Greeting()
    }
}