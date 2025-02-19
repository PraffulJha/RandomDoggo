package com.example.randomdogs.presentations.viewmodels

import androidx.lifecycle.ViewModel
import com.example.randomdogs.data.repository.GeneratedImageRepository
import javax.inject.Inject

class GeneratedImageDbViewModel @Inject constructor(private val generatedImageRepository: GeneratedImageRepository) : ViewModel() {

}