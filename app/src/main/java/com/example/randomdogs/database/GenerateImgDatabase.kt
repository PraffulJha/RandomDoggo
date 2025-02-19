package com.example.randomdogs.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.randomdogs.database.dao.GeneratedImageDao
import com.example.randomdogs.database.entities.GeneratedImgEntitiy

@Database(entities = [GeneratedImgEntitiy::class], version = 1)
abstract class GenerateImgDatabase : RoomDatabase() {
    abstract fun geneatedImageDao() : GeneratedImageDao
}