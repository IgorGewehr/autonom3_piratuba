package com.example.autonom3.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.autonom3.classes.MenuParams

@Composable
fun MenuSquares(
    modifier: Modifier = Modifier,
    onClickFunction: () -> Unit,
    navController: NavController,
    info: MenuParams
) {
    Surface(
        modifier = modifier
            .aspectRatio(1f)
            .clickable {
                onClickFunction()
                navController.navigate(info.title)
            }
            .padding(8.dp) // Padding adicional ao redor dos quadrados
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Gray.copy(alpha = 0.2f), Color.DarkGray.copy(alpha = 0.4f))
                )
            ),
        shadowElevation = 8.dp
    ) {
        Box {
            Image(
                painter = info.image,
                contentDescription = info.title,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f)),
                            startY = 300f
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = info.title,
                    color = Color.White,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}


