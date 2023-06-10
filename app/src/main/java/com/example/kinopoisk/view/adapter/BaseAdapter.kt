package com.example.kinopoisk.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<D> : RecyclerView.Adapter<BaseAdapter.BaseHolderView>() {
    private val _mData by lazy { mutableListOf<D>() }
    protected val mData : List<D> = _mData

    override fun onBindViewHolder(holder: BaseHolderView, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount() = _mData.size

    fun updateData(data: List<D>){
        if(_mData.isEmpty() && (_mData.isNotEmpty())){
            _mData.addAll(data)
        }
        else{
            _mData.clear()
            _mData.addAll(data)
        }
        notifyDataSetChanged()
    }

    abstract class BaseHolderView(view : View) : RecyclerView.ViewHolder(view) {
        abstract fun bindView(position: Int)
    }
}