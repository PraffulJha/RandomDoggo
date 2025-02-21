package com.example.randomdogs.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.randomdogs.database.entities.GeneratedImgEntitiy

@Dao
interface GeneratedImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dogImage: GeneratedImgEntitiy)

    @Query("SELECT * FROM GeneratedImage ORDER BY id DESC")
    suspend fun getLatestImages(): List<GeneratedImgEntitiy>

    @Query("DELETE FROM GeneratedImage WHERE id NOT IN (SELECT id FROM GeneratedImage ORDER BY id DESC LIMIT 20)")
    suspend fun clearOldImages()

    @Query("DELETE FROM GeneratedImage")
    suspend fun clearAllImages()

    @Query("SELECT COUNT(id) FROM GeneratedImage")
    suspend fun getDogCount(): Int

}