package com.tos.android_retrofit_mvvm_jetpack_kotlin.data.dataSource

import androidx.paging.PageKeyedDataSource
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.chaldal.product.ProductModelOld

/**
 *Created by tarikul on 8/9/20
 */

class OfferDataSource : PageKeyedDataSource<String, ProductModelOld>() {

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, ProductModelOld>
    ) {

        TODO("not implemented")
    }

    override fun loadAfter(
        params: LoadParams<String>,
        callback: LoadCallback<String, ProductModelOld>
    ) {

        TODO("not implemented")
    }

    override fun loadBefore(
        params: LoadParams<String>,
        callback: LoadCallback<String, ProductModelOld>
    ) {

        TODO("not implemented")
    }
}