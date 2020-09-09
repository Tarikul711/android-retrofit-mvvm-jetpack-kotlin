package com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.adapter

import ProductModel
import Results
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tos.android_retrofit_mvvm_jetpack_kotlin.R
import kotlinx.android.synthetic.main.product_layout.view.*

/**
 *Created by tarikul on 6/9/20
 */

class ProductListAdapter(private val products: ArrayList<Results>) :
    RecyclerView.Adapter<ProductListAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: Results) {
            itemView.apply {
                tvProductName.text = result.name
                tvProductQuantity.text = result.price_type
                tvProductPrice.text = "$ ${result.max_price}"
                Glide.with(ivProduct.context)
                    .load(result.image_urls[0])
                    .into(ivProduct)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product_layout,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun addProducts(results: List<Results>) {
        this.products.apply {
            clear()
            addAll(results)
        }
    }
}