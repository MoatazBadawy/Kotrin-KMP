package com.moataz.kotrin.features.imageView

import androidx.lifecycle.ViewModel
import com.moataz.kotrin.features.home.data.KotrinRepository
import com.moataz.kotrin.features.home.data.entites.KotrinObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ImageViewModel(kotrinRepository: KotrinRepository) : ViewModel() {

    private val _image = MutableStateFlow(KotrinObject())
    val images: StateFlow<KotrinObject> = _image.asStateFlow()

    }