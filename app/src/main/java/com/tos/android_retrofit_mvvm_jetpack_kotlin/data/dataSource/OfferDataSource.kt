package com.tos.android_retrofit_mvvm_jetpack_kotlin.data.dataSource

import androidx.paging.PageKeyedDataSource
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.chaldal.product.ProductModel

/**
 *Created by tarikul on 8/9/20
 */

class OfferDataSource : PageKeyedDataSource<String, ProductModel>() {

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, ProductModel>
    ) {

        TODO("not implemented")
    }

    override fun loadAfter(
        params: LoadParams<String>,
        callback: LoadCallback<String, ProductModel>
    ) {

        TODO("not implemented")
    }

    override fun loadBefore(
        params: LoadParams<String>,
        callback: LoadCallback<String, ProductModel>
    ) {

        TODO("not implemented")
    }
}