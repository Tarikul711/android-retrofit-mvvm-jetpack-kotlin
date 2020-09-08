package com.tos.myapplication.data.api


import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.common.ApiKeyModel
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.product.ProductModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("searchOld")
    suspend fun getProducts(@Body apiKey: ApiKeyModel): ProductModel


    @POST("searchOld")
    suspend fun getAllOfferedProducts(@Body apiKey: ApiKeyModel): ProductModel
}