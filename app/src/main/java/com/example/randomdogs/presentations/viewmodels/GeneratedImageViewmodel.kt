package com.example.randomdogs.presentations.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomdogs.data.models.ApiResponse
import com.example.randomdogs.data.models.ServerResponseGeneratedImage
import com.example.randomdogs.data.repository.GeneratedImageRepository
import com.example.randomdogs.data.repository.RandomDogsDbRepository
import com.example.randomdogs.database.entities.GeneratedImgEntitiy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneratedImageViewmodel @Inject constructor(private val generatedImageRepository: GeneratedImageRepository,
    private val generatedDbRepository : RandomDogsDbRepository) : ViewModel(){
    private val _dogImageResponse = MutableStateFlow<ApiResponse<ServerResponseGeneratedImage>>(ApiResponse.Idle)
    val dogImageResponse = _dogImageResponse.asStateFlow()
    private val _dogImageListFlow = MutableStateFlow<List<GeneratedImgEntitiy>>(emptyList())
    val dogImageList = _dogImageListFlow.asStateFlow()
    fun fetchDogImage(){
        viewModelScope.launch {
            _dogImageResponse.value = ApiResponse.Loading
            val response = generatedImageRepository.generateImage()
           if(response.isSuccessful){
               generatedDbRepository.insertDogsImage(response.body()!!.message)
              _dogImageResponse.value = ApiResponse.Success(response.body()!!)
           }
            else {
                _dogImageResponse.value = ApiResponse.Error("Error fetching images")
           }
        }
    }
    fun fetchAllDogImages(){
        viewModelScope.launch {
            generatedDbRepository.getAllDogImages().collect {
                generatedDogEntities ->
                if(generatedDogEntities.isEmpty()){
                    _dogImageListFlow.value = emptyList()
                }
                else {
                    _dogImageListFlow.value = generatedDogEntities
                }
            }
        }
    }
    fun clearDb(){
        viewModelScope.launch {
            _dogImageResponse.value = ApiResponse.Idle
            _dogImageListFlow.value = emptyList()
            generatedDbRepository.clearAllImages()
        }
    }
}