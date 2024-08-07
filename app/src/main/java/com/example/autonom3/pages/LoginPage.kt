package com.example.autonom3.pages

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.autonom3.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun LoginPage(onLoginClick: () -> Unit, modifier: Modifier = Modifier) {
    val backgroundImages = listOf(
        R.drawable.piratuba4,
        R.drawable.piratuba5,
        R.drawable.piratuba6,
        R.drawable.piratuba7
    )
    var currentImage by remember { mutableStateOf(backgroundImages[0]) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(7500)
            currentImage = backgroundImages[(backgroundImages.indexOf(currentImage) + 1) % backgroundImages.size]
        }
    }

    Scaffold(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo_piratuba),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center)
                            .padding(end = 25.dp)
                            .graphicsLayer {
                                rotationX = -30f
                                shadowElevation = 16f
                                shape = CircleShape
                                clip = true
                            },
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            AnimatedContent(
                targetState = currentImage,
                transitionSpec = {
                    fadeIn(animationSpec = keyframes {
                        durationMillis = 500
                    }) togetherWith fadeOut(animationSpec = keyframes {
                        durationMillis = 500
                    })
                }
            ) { image ->
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Background Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .background(
                        color = Color.White.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(24.dp) // Aumenta o padding para dar mais espaço interno
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center // Centraliza verticalmente o conteúdo
                ) {
                    Text(
                        text = "BEM-VINDO À PIRATUBA",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4285F4),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = onLoginClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4285F4),
                            contentColor = Color(0xFFFFFFFF)
                        ),
                        shape = RoundedCornerShape(8.dp) // Altera a forma do botão
                    ) {
                        Text(
                            text = "Acessar",
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

