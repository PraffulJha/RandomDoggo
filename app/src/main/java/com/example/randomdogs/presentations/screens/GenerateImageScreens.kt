package com.example.randomdogs.presentations.screens




import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.randomdogs.data.models.ApiResponse
import com.example.randomdogs.presentations.viewmodels.GeneratedImageViewmodel


@Composable
fun GenerateImageScreens(modifier: Modifier = Modifier,generatedImageApiViewmodel: GeneratedImageViewmodel) {

    val uiState by generatedImageApiViewmodel.dogImageResponse.collectAsState()

    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        val contentHeightModifier = Modifier.height(240.dp)
        when(uiState){
            is ApiResponse.Loading -> {
                CircularProgressIndicator(modifier = contentHeightModifier)
            }
            is ApiResponse.Success -> {
                AsyncImage(
                    model = (uiState as ApiResponse.Success).data.message,
                    contentDescription = "dog image",
                    modifier = contentHeightModifier
                )
            }
            is ApiResponse.Error -> {
                Text(text = "Error fetching image", modifier = contentHeightModifier)
            }
            is ApiResponse.Idle -> {
                Text(text = "Click button to generate image", modifier = contentHeightModifier)
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedButton(
            onClick = { generatedImageApiViewmodel.fetchDogImage() },
            modifier = Modifier.fillMaxWidth(0.6f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(66,134,244)),
            border = BorderStroke(1.dp,Color.Black)
        ) {
            Text(text = "Generate Dogs!", textAlign = TextAlign.Center)
        }

    }

}
