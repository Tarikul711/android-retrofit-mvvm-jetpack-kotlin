package com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.repository.ChaldalListRepository
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.viewmodel.ChaldalListViewModel
import com.tos.myapplication.data.api.ApiHelper
import java.lang.IllegalArgumentException

/**
 *Created by tarikul on 5/9/20
 */
class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChaldalListViewModel::class.java)) {
            return ChaldalListViewModel(ChaldalListRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}