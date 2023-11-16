package com.qs.mvvm.structures.view.navigation

import android.annotation.SuppressLint
import com.qs.mvvm.structures.R
import com.qs.mvvm.structures.base.adapter.DataBindingRecyclerViewAdapter
import com.qs.mvvm.structures.base.adapter.ViewModelItem
import com.qs.mvvm.structures.common.EmptyItemViewModel
import com.qs.mvvm.structures.common.LogoutItemViewModel

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