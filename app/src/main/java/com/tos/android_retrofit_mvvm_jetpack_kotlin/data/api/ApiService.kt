package com.tos.myapplication.data.api


import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.product.ProductModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

/*    @GET("users")
    suspend fun getUsers(): List<User>*/

    @POST("searchOld")
    fun getProducts(@Body apiKey: String): ProductModel


}