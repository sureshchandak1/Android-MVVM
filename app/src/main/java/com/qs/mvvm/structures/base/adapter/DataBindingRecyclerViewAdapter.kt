package com.qs.mvvm.structures.base.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.qs.mvvm.structures.BR

abstract class DataBindingRecyclerViewAdapter(viewModels: MutableList<ViewModelItem>) :
    RecyclerView.Adapter<DataBindingRecyclerViewHolder<*>>() {

    protected var mViewModels: MutableList<ViewModelItem> = ArrayList()

    init {
        mViewModels = viewModels
        onViewModelListChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingRecyclerViewHolder<*> {
        val v = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
        return DataBindingRecyclerViewHolder(DataBindingUtil.bind(v))
    }

    override fun onBindViewHolder(holder: DataBindingRecyclerViewHolder<*>, position: Int) {
        if (mViewModels.size > position) {
            val viewModel = mViewModels[position]
            holder.binding!!.setVariable(BR.vm, viewModel)
            holder.binding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewModelLayoutMap[mViewModels[position].javaClass]!!
    }

    override fun getItemCount(): Int {
        return mViewModels.size
    }

    abstract val viewModelLayoutMap: Map<Class<*>, Int>

    @SuppressLint("NotifyDataSetChanged")
    fun onViewModelListChanged() {
        notifyDataSetChanged()
    }

    fun close() {}

    @SuppressLint("NotifyDataSetChanged")
    fun refreshList(viewModels: List<ViewModelItem>?) {
        mViewModels.clear()
        mViewModels.addAll(viewModels!!)
        notifyDataSetChanged()
    }

}