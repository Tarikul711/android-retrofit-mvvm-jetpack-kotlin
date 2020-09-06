package com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tos.android_retrofit_mvvm_jetpack_kotlin.R
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.product.ProductModel
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.base.ViewModelFactory
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.adapter.ProductListAdapter
import com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.viewmodel.ProductListViewModel
import com.tos.myapplication.data.api.ApiHelper
import com.tos.myapplication.data.api.RetrofitBuilder
import com.tos.myapplication.utils.Status
import com.tos.myapplication.utils.Status.*
import kotlinx.android.synthetic.main.activity_main.*

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
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(ProductListViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ProductListAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        val apiKey: String =
            "{\"apiKey\":\"e964fc2d51064efa97e94db7c64bf3d044279d4ed0ad4bdd9dce89fecc9156f0\",\"storeId\":1,\"warehouseId\":8,\"pageSize\":100,\"currentPageIndex\":0,\"query\":\"\",\"productVariantId\":-1,\"canSeeOutOfStock\":\"false\",\"filters\":[\"categories%3D235\"]}"
        viewModel.getProducts(apiKey).observe(this, Observer {
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


    private fun retrieveList(product: ProductModel) {
        adapter.apply {
            addProducts(product.hits)
            notifyDataSetChanged()
        }
    }
}
