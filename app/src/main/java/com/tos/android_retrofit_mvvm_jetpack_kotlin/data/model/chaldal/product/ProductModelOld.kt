package com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.chaldal.product

/**
 *Created by tarikul on 6/9/20
 */

data class ProductModelOld (

    val page : Int,
    val nbPages : Int,
    val hitsPerPage : Int,
    val nbHits : Int,
    val hits : List<Hits>
)