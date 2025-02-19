package com.example.randomdogs.data.remote

import com.example.randomdogs.data.models.ServerResponseGeneratedImage
import retrofit2.Call
import retrofit2.http.GET

interface ApiInstances {

    @GET("image/random")
    fun generateRandomImages() : Call<ServerResponseGeneratedImage>
}