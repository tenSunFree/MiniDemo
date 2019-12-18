package com.home.minidemo.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.home.minidemo.R
import com.home.minidemo.model.pojo.GetStoreListPojo

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var storeList: List<GetStoreListPojo.Store>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.imageView.context)
            .load(storeList!![position].imageUrl).into(holder.imageView)
        holder.nameTextView.text = storeList!![position].name
        holder.addressTextView.text = "地址︰" + storeList!![position].address
        holder.phoneTextView.text = "電話︰" + storeList!![position].phone
        holder.businessHoursTextView.text = "營業時間︰" + storeList!![position].businessHours
    }

    override fun getItemCount(): Int {
        return storeList!!.size
    }

    fun setPostList(photoList: List<GetStoreListPojo.Store>?) {
        this.storeList = photoList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val nameTextView: TextView = itemView.findViewById(R.id.text_view_name)
        val addressTextView: TextView = itemView.findViewById(R.id.text_view_address)
        val phoneTextView: TextView = itemView.findViewById(R.id.text_view_phone)
        val businessHoursTextView: TextView = itemView.findViewById(R.id.text_view_business_hours)
    }
}