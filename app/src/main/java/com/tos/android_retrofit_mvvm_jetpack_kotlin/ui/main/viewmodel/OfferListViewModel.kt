package com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.paging.PagedList
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.common.ApiKeyModel
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.repository.ChaldalListRepository
import com.tos.myapplication.utils.Resource
import kotlinx.coroutines.Dispatchers

/**
 *Created by tarikul on 6/9/20
 */

class OfferListViewModel(private val chaldalListRepository: ChaldalListRepository) : ViewModel() {

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(40)
            .setEnablePlaceholders(false)
            .build()
    }

    fun getProducts(apiKey: ApiKeyModel) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = chaldalListRepository.getProducts(apiKey)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}
