package com.example.autonom3.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autonom3.classes.MenuParams

@Composable
fun MenuSquares(
    modifier: Modifier = Modifier,
    onClickFunction: () -> Unit,
    info: MenuParams
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clickable { onClickFunction() }
            .padding(8.dp) // Padding adicional ao redor dos quadrados
            .background(Color.Gray.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = info.image,
            contentDescription = info.title,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent), // Imagem cobre o fundo do Box
            contentScale = ContentScale.Crop
        )

        // Overlay para garantir que o texto seja legível sobre a imagem
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f)) // Sobreposição escura para legibilidade
                .padding(8.dp) // Padding interno para o texto
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = info.title,
                color = Color.White,
                fontSize = 18.sp,
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
            )
        }
    }
}
