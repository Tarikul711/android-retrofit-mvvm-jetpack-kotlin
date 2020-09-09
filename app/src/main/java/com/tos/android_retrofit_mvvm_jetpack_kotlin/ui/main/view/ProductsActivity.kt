package com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.view

import ProductModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.tos.android_retrofit_mvvm_jetpack_kotlin.R
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.common.ApiKeyModel
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.chaldal.product.ProductModelOld
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.base.ViewModelFactory
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.adapter.ChaldalListAdapter
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.adapter.ProductListAdapter
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.viewmodel.ChaldalListViewModel
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.viewmodel.ProductListViewModel
import com.tos.myapplication.data.api.ApiHelper
import com.tos.myapplication.data.api.RetrofitBuilder
import com.tos.myapplication.utils.Status.*
import kotlinx.android.synthetic.main.activity_main.*

class ProductsActivity : AppCompatActivity() {

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
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(ProductListViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ProductListAdapter(arrayListOf())
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getProducts().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }

            }
        })
    }


    private fun retrieveList(productModel: ProductModel) {
        adapter.apply {
            addProducts(productModel.results)
            notifyDataSetChanged()
        }
    }
}
