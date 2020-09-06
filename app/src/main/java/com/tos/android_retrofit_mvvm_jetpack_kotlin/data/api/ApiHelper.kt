package com.tos.myapplication.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getProducts(apiKeys: String) = apiService.getProducts(apiKeys)
}