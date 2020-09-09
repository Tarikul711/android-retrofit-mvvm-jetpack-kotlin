package com.tos.myapplication.data.api


import ProductModel
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.common.ApiKeyModel
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.chaldal.product.ProductModelOld
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("searchOld")
    suspend fun getProductsOld(@Body apiKey: ApiKeyModel): ProductModelOld


    @POST("searchOld")
    suspend fun getAllOfferedProducts(@Body apiKey: ApiKeyModel): ProductModelOld


    @GET("products/?page=1&limit=12&brand=garnier-104672b97")
    suspend fun getProducts(): ProductModel
}