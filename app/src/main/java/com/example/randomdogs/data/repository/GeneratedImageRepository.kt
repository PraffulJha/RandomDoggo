package com.example.randomdogs.data.repository

import com.example.randomdogs.data.models.ServerResponseGeneratedImage
import retrofit2.Response

interface GeneratedImageRepository {

    suspend fun generateImage() : Response<ServerResponseGeneratedImage>
}