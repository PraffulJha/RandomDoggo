package com.example.randomdogs.data.repository.repoImpl

import com.example.randomdogs.data.repository.RandomDogsDbRepository
import com.example.randomdogs.database.dao.GeneratedImageDao
import com.example.randomdogs.database.entities.GeneratedImgEntitiy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RandomDogsDbRepoImpl @Inject constructor(private val generatedImageDao: GeneratedImageDao) : RandomDogsDbRepository {
    override suspend fun insertDogsImage(dogsImageUrl: String) {
        if (generatedImageDao.getDogCount() >= 20) {
            generatedImageDao.clearOldImages()
        }
        generatedImageDao.insert(GeneratedImgEntitiy(imageUrl = dogsImageUrl))
    }

    override suspend fun clearOldImages() {
        generatedImageDao.clearOldImages()
    }

    override suspend fun clearAllImages() {
        generatedImageDao.clearAllImages()
    }

    override suspend fun getAllDogImages(): Flow<List<GeneratedImgEntitiy>> = flow {
        emit(generatedImageDao.getLatestImages())
    }


}