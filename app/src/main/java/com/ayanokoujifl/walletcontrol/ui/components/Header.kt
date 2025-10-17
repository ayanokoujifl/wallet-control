package com.ayanokoujifl.walletcontrol.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ayanokoujifl.walletcontrol.R
import com.ayanokoujifl.walletcontrol.ui.routes.Screen

@Composable
fun Header(modifier: Modifier = Modifier, navController: NavController) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val avatar = painterResource(R.drawable.avatar)
        Image(
            painter = avatar,
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape), contentScale = ContentScale.Crop,
            alignment = Alignment.TopStart
        )
        Text(
            "Carteira Digital",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 16.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Box(Modifier.clickable(enabled = true, onClick = { navController.navigate(Screen.Settings.route) })) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Manage Settings",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        //ThemeSwitcher(darkTheme = isDarkTheme, onToggle = setTheme, modifier = Modifier.padding(end = 16.dp))
    }
}


