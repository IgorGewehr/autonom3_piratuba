package com.example.autonom3.pages

import android.icu.text.CaseMap.Title
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import com.example.autonom3.R
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun LoginPage(onLoginClick: () -> Unit, modifier: Modifier = Modifier) {

    val backgroundImages = listOf(
        R.drawable.piratuba4,
        R.drawable.piratuba5,
        R.drawable.piratuba6,
        R.drawable.piratuba7
    )
    var currentImage by remember {mutableStateOf(backgroundImages[0])}

    LaunchedEffect(Unit) {
        while (true) {
            delay(7500) // 5 segundos
            currentImage = backgroundImages[(backgroundImages.indexOf(currentImage) + 1) % backgroundImages.size]
        }
    }

    Scaffold (
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
                            .padding(end = 25.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){
            AnimatedContent(
                targetState = currentImage,
                transitionSpec = {
                    fadeIn(tween(500)) togetherWith fadeOut(tween(500))
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
                        color = Color.White.copy(alpha = 0.8f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .size(300.dp, 175.dp)
            ){
                Column (
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = "BEM-VINDO À PIRATUBA",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4285F4),
                        textAlign = TextAlign.Center)

                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = onLoginClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4285F4),
                            contentColor = Color(0xFFFFFFFF)
                        ),
                        shape = RectangleShape
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 2.dp), // Padding horizontal para o Row
                            horizontalArrangement = Arrangement.Start, // Alinha o conteúdo ao início horizontalmente
                            verticalAlignment = Alignment.CenterVertically // Alinha o conteúdo ao centro verticalmente
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.gicon),
                                contentDescription = "google icon",
                                modifier = Modifier.padding(end = 10.dp) // Espaçamento à direita do ícone
                            )

                            Text(
                                text = "Logar com o Google",
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
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginPage() {
    LoginPage(
        onLoginClick = {},
        modifier = Modifier
    )
}
