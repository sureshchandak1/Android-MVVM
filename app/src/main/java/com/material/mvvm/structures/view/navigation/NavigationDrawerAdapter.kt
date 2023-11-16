package com.material.mvvm.structures.view.navigation

import android.annotation.SuppressLint
import com.material.mvvm.structures.R
import com.material.mvvm.structures.base.adapter.DataBindingRecyclerViewAdapter
import com.material.mvvm.structures.base.adapter.ViewModelItem
import com.material.mvvm.structures.common.EmptyItemViewModel
import com.material.mvvm.structures.common.LogoutItemViewModel

class NavigationDrawerAdapter(viewModels: MutableList<ViewModelItem>) : DataBindingRecyclerViewAdapter(viewModels) {

    private val mViewModelMap = HashMap<Class<*>, Int>()

    init {
        mViewModelMap[NavigationDrawerItemViewModel::class.java] = R.layout.navigation_drawer_item
        mViewModelMap[LogoutItemViewModel::class.java] = R.layout.logout_item
        mViewModelMap[EmptyItemViewModel::class.java] = R.layout.empty_item
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(itemList: MutableList<ViewModelItem>) {
        mViewModels = itemList
        notifyDataSetChanged()
    }

    override val viewModelLayoutMap: Map<Class<*>, Int>
        get() = mViewModelMap

}