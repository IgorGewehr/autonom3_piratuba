package com.example.autonom3.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.lang.reflect.Modifier


@Composable
fun AppNavigation(modifier: androidx.compose.ui.Modifier){

    val navController = rememberNavController()
    NavHost(navController, startDestination = "login"){
        composable("login") {
            LoginPage(onLoginClick = {
                navController.navigate("DiscoverPage")
            })
        }
        composable("discoverPage") {
            DiscoverPage()
        }
    }
}