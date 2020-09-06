package com.tos.myapplication.data.api

class ApiHelper(private val apiService: ApiService) {

    /*suspend fun getUsers() = apiService.getUsers()*/

    fun getProducts(apiKeys: String) = apiService.getProducts(apiKeys)
}