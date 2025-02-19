package com.example.randomdogs.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GeneratedImageDao {

    @Insert
    fun saveImageUrl(imageUrl : String)

    @Query("SELECT * FROM GeneratedImage ORDER BY id DESC LIMIT 20")
    fun getLatestImageUrl(): List<String>

    @Query("DELETE FROM GeneratedImage")
    suspend fun deleteAllImg()
}