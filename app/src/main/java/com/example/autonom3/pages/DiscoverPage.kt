package com.example.autonom3.pages

import android.view.Menu
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.autonom3.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.autonom3.classes.MenuParams
import com.example.autonom3.composables.MenuSquares

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun DiscoverPage(modifier: Modifier = Modifier, navController: NavController){
    val menuItems = listOf(
        MenuParams("Restaurantes", painterResource(id = R.drawable.piratuba5)),
        MenuParams("Hoteis", painterResource(id = R.drawable.piratuba6)),
        MenuParams("Turismo", painterResource(id = R.drawable.piratuba7)),
        MenuParams("Eventos", painterResource(id = R.drawable.piratuba4)),
        MenuParams("Souvenirs", painterResource(id = R.drawable.piratuba1)),
        MenuParams("Águas Termais", painterResource(id = R.drawable.piratuba2)),
    )

    Scaffold(
        modifier = modifier
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
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Número de colunas no grid
            contentPadding = innerPadding, // Padding ao redor do grid
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Espaçamento entre colunas
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espaçamento entre linhas
        ) {
            items(menuItems.size) { index ->
                val item = menuItems[index]
                MenuSquares(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp), // Padding adicional ao redor dos quadrados
                    onClickFunction = { /* Ação ao clicar */ },
                    navController = navController,
                    info = item
                )

            }
        }
    }
}