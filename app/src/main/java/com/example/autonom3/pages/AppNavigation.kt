package com.example.autonom3.pages

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier

@Composable
fun AppNavigation(context: Context, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "login") {
        composable("login") {
            LoginPage(onLoginClick = {
                navController.navigate("discoverPage")
            })
        }
        composable("discoverPage") {
            DiscoverPage(navController = navController)
        }
        composable("Restaurantes") {
            RestaurantsPage( navController = navController)
        }
        composable("Hoteis") {
            HotelsPage()
        }
    }
}
