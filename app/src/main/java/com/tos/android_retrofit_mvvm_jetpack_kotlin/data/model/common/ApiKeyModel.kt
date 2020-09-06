package com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.common

/**
 *Created by tarikul on 6/9/20
 */
data class ApiKeyModel(

    val apiKey: String,
    val storeId: Int,
    val warehouseId: Int,
    val pageSize: Int,
    val currentPageIndex: Int,
    val query: String,
    val productVariantId: Int,
    val canSeeOutOfStock: Boolean,
    val filters: List<String>
)