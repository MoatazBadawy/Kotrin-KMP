package com.moataz.kotrin.features.home.data

class KotrinRepository (
    private val kotrinApi: KotrinApi,
) {
    suspend fun getData() = kotrinApi.getData()
}