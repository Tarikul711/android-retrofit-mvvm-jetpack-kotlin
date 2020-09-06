package com.tos.myapplication.data.api

import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.common.ApiKeyModel

class ApiHelper(private val apiService: ApiService) {

    suspend fun getProducts(apiKeys: ApiKeyModel) = apiService.getProducts(apiKeys)
}