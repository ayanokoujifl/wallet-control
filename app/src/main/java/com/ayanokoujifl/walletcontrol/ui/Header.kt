package com.ayanokoujifl.walletcontrol.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayanokoujifl.walletcontrol.R

@Composable
fun Header(modifier: Modifier = Modifier, isDarkTheme: Boolean = isSystemInDarkTheme(), setTheme: () -> Unit) {

    Row(modifier = modifier.fillMaxWidth(), Arrangement.Center) {
        val avatar = painterResource(R.drawable.avatar)
        Image(painter = avatar, contentDescription = null, modifier=Modifier.size(32.dp))
        Text(
            "Carteira Digital",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        //ThemeSwitcher(darkTheme = isDarkTheme, onToggle = setTheme, modifier = Modifier.padding(end = 16.dp))
    }
}


