package com.example.randomdogs.data.repository

import com.example.randomdogs.database.entities.GeneratedImgEntitiy
import kotlinx.coroutines.flow.Flow

interface RandomDogsDbRepository {

    suspend fun insertDogsImage(dogsImageUrl : String)

    suspend fun clearOldImages()

    suspend fun clearAllImages()

    suspend fun getAllDogImages(): Flow<List<GeneratedImgEntitiy>>
}