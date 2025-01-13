package com.moataz.kotrin.features.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moataz.kotrin.features.home.data.KotrinRepository
import com.moataz.kotrin.features.home.data.entites.KotrinObject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(kotrinRepository: KotrinRepository) : ViewModel() {

    private val _wallpapers = MutableStateFlow(KotrinObject())
    val wallpapers: StateFlow<KotrinObject> = _wallpapers.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            _isLoading.value = true
            kotrinRepository.getData()
                .let { _wallpapers.value = it }
            _isLoading.value = false
        }
    }
}