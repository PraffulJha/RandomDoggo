package com.example.randomdogs.presentations.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.randomdogs.presentations.screens.GenerateImageScreens
import com.example.randomdogs.presentations.screens.HomeScreen
import com.example.randomdogs.presentations.screens.ViewImagesScreens
import com.example.randomdogs.presentations.viewmodels.GeneratedImageViewmodel

@Composable
fun NavigationGraph(viewmodel: GeneratedImageViewmodel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("generateImg") { GenerateImageScreens(generatedImageApiViewmodel = viewmodel) }
        composable("viewImg") { ViewImagesScreens(viewmodel = viewmodel) }
    }

}

