package com.example.randomdogs.data.repository.repoImpl

import com.example.randomdogs.data.remote.ApiInstances
import com.example.randomdogs.data.models.ServerResponseGeneratedImage
import com.example.randomdogs.data.repository.GeneratedImageRepository
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class GeneratedImageRepoImpl @Inject constructor(private val apiInstances: ApiInstances) : GeneratedImageRepository{
    override suspend fun generateImage(): Response<ServerResponseGeneratedImage> {
        return apiInstances.generateRandomImages().awaitResponse()
    }
}