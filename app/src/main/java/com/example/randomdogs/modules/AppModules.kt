package com.example.randomdogs.modules

import android.content.Context
import androidx.room.Room
import com.example.randomdogs.data.remote.ApiInstances
import com.example.randomdogs.data.repository.GeneratedImageRepository
import com.example.randomdogs.data.repository.RandomDogsDbRepository
import com.example.randomdogs.data.repository.repoImpl.GeneratedImageRepoImpl
import com.example.randomdogs.data.repository.repoImpl.RandomDogsDbRepoImpl
import com.example.randomdogs.database.GenerateImgDatabase
import com.example.randomdogs.database.dao.GeneratedImageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Provides
    @Singleton
    fun provideApiInstance() : ApiInstances {
        val retrofitInstance = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofitInstance.create(ApiInstances::class.java)
    }
    @Provides
    @Singleton
    fun provideApiRepository(apiInterface: ApiInstances): GeneratedImageRepository {
        return GeneratedImageRepoImpl(apiInterface)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): GenerateImgDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            GenerateImgDatabase::class.java,
            "GeneratedImgDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: GenerateImgDatabase): GeneratedImageDao {
        return database.geneatedImageDao()
    }

    @Provides
    @Singleton
    fun providesRandomDogsRepository(generatedImageDao: GeneratedImageDao) : RandomDogsDbRepository {
        return RandomDogsDbRepoImpl(generatedImageDao)
    }

}