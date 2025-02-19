package com.example.randomdogs.presentations.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.randomdogs.presentations.screens.GenerateImageScreens
import com.example.randomdogs.presentations.screens.HomeScreen
import com.example.randomdogs.presentations.screens.ViewImagesScreens

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("home") { HomeScreen() }
        composable("register") { GenerateImageScreens() }
        composable("register") { ViewImagesScreens() }
    }

}