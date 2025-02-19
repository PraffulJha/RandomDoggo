package com.example.randomdogs.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "GeneratedImage")
data class GeneratedImgEntitiy (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val imageUrl : String
)