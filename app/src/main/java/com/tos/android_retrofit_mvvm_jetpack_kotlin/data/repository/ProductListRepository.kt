package com.tos.android_retrofit_mvvm_jetpack_kotlin.data.repository

import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.common.ApiKeyModel
import com.tos.myapplication.data.api.ApiHelper

/**
 *Created by tarikul on 6/9/20
 */

class ProductListRepository(private val apiHelper: ApiHelper) {
    suspend fun getProducts(apiKeys: ApiKeyModel) = apiHelper.getProducts(apiKeys)
}
