package com.ayanokoujifl.walletcontrol.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.RequestQuote
import androidx.compose.material.icons.outlined.Savings
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ayanokoujifl.walletcontrol.ui.components.Card
import com.ayanokoujifl.walletcontrol.ui.components.CardLayout
import com.ayanokoujifl.walletcontrol.ui.components.Header

@Composable
fun Home(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier) {
        Header(navController = navController)
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally).padding(top = 36.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Card(cardIcon = Icons.Outlined.Savings, cardContent = "Controle")
                    Card(
                        cardIcon = Icons.Outlined.RequestQuote,
                        cardContent = "Extrato",
                        layout = CardLayout.VERTICAL
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Card(
                        cardIcon = Icons.Outlined.AttachMoney,
                        cardContent = "Receita",
                        layout = CardLayout.VERTICAL
                    )
                    Card(cardIcon = Icons.Outlined.Sell, cardContent = "Despesas")

                }
            }

        }
    }
}