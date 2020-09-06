package com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.tos.android_retrofit_mvvm_jetpack_kotlin.R
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.adapter.ProductListAdapter
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.viewmodel.ProductListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductListViewModel
    private lateinit var adapter: ProductListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {

    }

    private fun setupUI() {

    }

    private fun setupObservers() {

    }
}
