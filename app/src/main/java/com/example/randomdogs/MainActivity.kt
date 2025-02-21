package com.example.randomdogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.randomdogs.presentations.navigation.NavigationGraph
import com.example.randomdogs.presentations.viewmodels.GeneratedImageViewmodel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: GeneratedImageViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
    @Composable
    fun MyApp() {
        MaterialTheme {
            NavigationGraph(viewModel)
        }
    }
}

