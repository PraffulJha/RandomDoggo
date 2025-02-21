package com.example.randomdogs.presentations.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.randomdogs.presentations.viewmodels.GeneratedImageViewmodel

@Composable
fun HomeScreen(modifier: Modifier = Modifier,navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Random Dog Generator!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier.height(100.dp))

        OutlinedButton (
            onClick = {
                navController.navigate("generateImg")
            },
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .padding(bottom = 8.dp),
            border = BorderStroke(1.dp,Color.Black),
            colors = ButtonDefaults.buttonColors(containerColor = Color(66,134,244))
        ) {
            Text(text = "Generate Dog!")
        }

        OutlinedButton(
            onClick = {
                navController.navigate("viewImg")
            },
            modifier = Modifier.fillMaxWidth(0.6f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(66,134,244)),
            border = BorderStroke(1.dp,Color.Black)
        ) {
            Text(text = "My Recently Generated Dogs!", textAlign = TextAlign.Center)
        }
    }
}


