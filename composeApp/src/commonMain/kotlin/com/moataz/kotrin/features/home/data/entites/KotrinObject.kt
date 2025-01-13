package com.moataz.kotrin.features.home.data.entites

import kotlinx.serialization.Serializable

@Serializable
data class KotrinObject(
    val features: List<Feature> = emptyList(),
    val top: List<Top> = emptyList()
)