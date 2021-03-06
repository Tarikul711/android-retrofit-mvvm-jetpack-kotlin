package com.tos.android_retrofit_mvvm_jetpack_kotlin.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tos.android_retrofit_mvvm_jetpack_kotlin.R
import com.tos.android_retrofit_mvvm_jetpack_kotlin.data.model.chaldal.product.Hits
import kotlinx.android.synthetic.main.product_layout.view.*

/**
 *Created by tarikul on 6/9/20
 */

class OfferListAdapter(private val products: ArrayList<Hits>) :
    PagedListAdapter<Hits, OfferListAdapter.DataViewHolder>(DiffUtilCallBack()) {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hits: Hits) {
            itemView.apply {
                tvProductName.text = hits.bengaliName
                tvProductQuantity.text = hits.subText
                tvProductPrice.text = "$ ${hits.price}"
                Glide.with(ivProduct.context)
                    .load(hits.picturesUrls[0])
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

    fun addProducts(hits: List<Hits>) {
        this.products.apply {
            clear()
            addAll(hits)
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Hits>() {
        override fun areItemsTheSame(oldItem: Hits, newItem: Hits): Boolean {
            return oldItem.productId == newItem.productId
        }

        override fun areContentsTheSame(oldItem: Hits, newItem: Hits): Boolean {
            return oldItem.equals(newItem)
/*
            return oldItem.title == newItem.title
                    && oldItem.score == newItem.score
                    && oldItem.commentCount == newItem.commentCount*/
        }


    }

}
