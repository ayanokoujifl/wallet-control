import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ThemeSwitcher(
    darkTheme: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier,
    width: Dp = 64.dp, // Largura total do switch
    height: Dp = 32.dp, // Altura total do switch
    thumbPadding: Dp = 4.dp, // Espaçamento interno para o polegar
    animationDuration: Int = 300 // Duração da animação em ms
) {
    val interactionSource = remember { MutableInteractionSource() }

    // Cor da trilha de fundo
    val trackColor by animateColorAsState(
        targetValue = if (darkTheme) Color(0xFF333333) else Color(0xFFE0E0E0),
        animationSpec = tween(animationDuration)
    )

    // Cor do polegar
    val thumbColor by animateColorAsState(
        targetValue = if (darkTheme) Color.White else Color.Black,
        animationSpec = tween(animationDuration)
    )

    // Posição horizontal do polegar
    val thumbOffset by animateDpAsState(
        targetValue = if (darkTheme) width - height + thumbPadding else thumbPadding,
        animationSpec = tween(animationDuration)
    )

    // Tamanho do ícone
    val iconSize = height - (thumbPadding * 2)

    Box(
        modifier = modifier
            .width(width)
            .height(height)
            .clip(CircleShape) // Borda arredondada para a trilha
            .background(trackColor)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onToggle() },
        contentAlignment = Alignment.CenterStart
    ) {
        // Ícone de SOL (visível quando o tema é CLARO)
        Icon(
            imageVector = Icons.Default.WbSunny,
            contentDescription = "Light Theme Icon",
            modifier = Modifier
                .size(iconSize)
                .align(Alignment.CenterEnd) // Alinha no final
                .padding(end = thumbPadding * 0.5f) // Ajusta levemente a posição
                .graphicsLayer(alpha = if (darkTheme) 0f else 1f), // Mostra/esconde
            tint = Color.Black // Ícone de sol em preto
        )

        // Ícone de LUA (visível quando o tema é ESCURO)
        Icon(
            imageVector = Icons.Default.Nightlight,
            contentDescription = "Dark Theme Icon",
            modifier = Modifier
                .size(iconSize)
                .align(Alignment.CenterStart) // Alinha no início
                .padding(start = thumbPadding * 0.5f) // Ajusta levemente a posição
                .graphicsLayer(alpha = if (darkTheme) 1f else 0f), // Mostra/esconde
            tint = Color.White // Ícone de lua em branco
        )

        Box(
            modifier = Modifier
                .offset(x = thumbOffset)
                .size(height - (thumbPadding * 2))
                .clip(CircleShape)
                .background(thumbColor)
        )
    }
}