package com.example.randomdogs.presentations.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.randomdogs.database.entities.GeneratedImgEntitiy
import com.example.randomdogs.presentations.viewmodels.GeneratedImageViewmodel

@Composable
fun  ViewImagesScreens(modifier: Modifier = Modifier,viewmodel: GeneratedImageViewmodel) {
    viewmodel.fetchAllDogImages()
    val state by  viewmodel.dogImageList.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(state) { generatedImgEntity ->
                DogsListItem(modifier = Modifier.size(240.dp),generatedImgEntity)
            }
        }
        OutlinedButton( onClick = { viewmodel.clearDb() },
            modifier = Modifier.fillMaxWidth(0.6f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(66,134,244)),
            border = BorderStroke(1.dp, Color.Black)
        )  {
            Text(text = "Clear Dogs !")
        }
    }


}
@Composable
fun DogsListItem(modifier: Modifier = Modifier, generatedImgEntitiy: GeneratedImgEntitiy) {
    AsyncImage(
        model = generatedImgEntitiy.imageUrl,
        contentDescription = "dog image",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}