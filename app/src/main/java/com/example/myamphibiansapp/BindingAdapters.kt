package com.example.myamphibiansapp

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myamphibiansapp.network.Amphibian
import com.example.myamphibiansapp.ui.AmphibianApiStatus
import com.example.myamphibiansapp.ui.AmphibianListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Amphibian>?){
    val adapter = recyclerView.adapter as AmphibianListAdapter
    adapter.submitList(data)
}

@BindingAdapter("amphibiansApiStatus")
fun bindStatus(statusImageView: ImageView, status: AmphibianApiStatus?){
    when(status){
        AmphibianApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        AmphibianApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        AmphibianApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        else -> {}
    }
}