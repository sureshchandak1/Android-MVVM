package com.material.mvvm.structures.view.recyclerview

import android.annotation.SuppressLint
import com.material.mvvm.structures.R
import com.material.mvvm.structures.base.adapter.DataBindingRecyclerViewAdapter
import com.material.mvvm.structures.base.adapter.ViewModelItem
import com.material.mvvm.structures.common.FreeTrialItemViewModel

class RecyclerViewAdapter(viewModels: MutableList<ViewModelItem>) : DataBindingRecyclerViewAdapter(viewModels) {

    private val mViewModelMap = HashMap<Class<*>, Int>()

    init {
        mViewModelMap[RecyclerViewItemViewModel::class.java] = R.layout.paid_courses_item
        mViewModelMap[RecyclerViewGridItemViewModel::class.java] = R.layout.paid_courses_grid_item
        mViewModelMap[FreeTrialItemViewModel::class.java] = R.layout.free_trial_item
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(itemList: MutableList<ViewModelItem>) {
        mViewModels = itemList
        notifyDataSetChanged()
    }

    fun getList() : MutableList<ViewModelItem> {
        return mViewModels
    }

    override val viewModelLayoutMap: Map<Class<*>, Int>
        get() = mViewModelMap

}