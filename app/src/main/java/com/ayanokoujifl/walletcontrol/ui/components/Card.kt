package com.ayanokoujifl.walletcontrol.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


enum class CardLayout {
    HORIZONTAL, VERTICAL
}

@Composable
fun Card(
    modifier: Modifier = Modifier,
    cardIcon: ImageVector,
    cardContent: String,
    layout: CardLayout = CardLayout.HORIZONTAL,
    onClick: () -> Unit = {}
) {

    when (layout) {
        CardLayout.HORIZONTAL -> HorizontalCard(modifier, cardIcon, cardContent)
        CardLayout.VERTICAL -> VerticalCard(modifier, cardIcon, cardContent)
    }


}

@Composable
private fun HorizontalCard(
    modifier: Modifier = Modifier,
    cardIcon: ImageVector,
    cardContent: String
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val defaultColor = MaterialTheme.colorScheme.secondary
    val pressedColor = MaterialTheme.colorScheme.tertiary

    Box(
        modifier
            .size(216.dp, 90.dp)
            .background(color = MaterialTheme.colorScheme.secondary)
            .border(
                color = MaterialTheme.colorScheme.tertiary,
                width = 2.dp,
                shape = RoundedCornerShape(4.dp)
            )
            .clip(RoundedCornerShape(4.dp)),
    )
    {
        Icon(
            imageVector = cardIcon,
            contentDescription = null,
            Modifier
                .padding(start = 12.dp)
                .size(32.dp)
                .align(Alignment.CenterStart),
            tint = MaterialTheme.colorScheme.tertiary
        )
        Text(
            cardContent,
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.tertiary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 12.dp)
        )

    }
}

@Composable
private fun VerticalCard(
    modifier: Modifier = Modifier,
    cardIcon: ImageVector,
    cardContent: String
) {
    Column(
        modifier
            .size(90.dp)
            .background(color = MaterialTheme.colorScheme.secondary)
            .border(
                color = MaterialTheme.colorScheme.tertiary,
                width = 2.dp,
                shape = RoundedCornerShape(4.dp)
            )
            .clip(RoundedCornerShape(4.dp)),
    )
    {
        Icon(
            imageVector = cardIcon,
            contentDescription = null,
            Modifier
                .padding(start = 12.dp, top = 12.dp)
                .size(32.dp),
            tint = MaterialTheme.colorScheme.tertiary
        )
        Text(
            cardContent,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.tertiary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp, bottom = 12.dp)
                .fillMaxWidth()
        )

    }
}