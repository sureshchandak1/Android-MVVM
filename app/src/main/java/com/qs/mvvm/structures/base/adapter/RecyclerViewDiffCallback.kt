package com.qs.mvvm.structures.base.adapter

import androidx.recyclerview.widget.DiffUtil

class RecyclerViewDiffCallback(
    private val mOldViewModelList: List<ViewModelItem>,
    private val mNewViewModelList: List<ViewModelItem>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return mOldViewModelList.size
    }

    override fun getNewListSize(): Int {
        return mNewViewModelList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldViewModelList[oldItemPosition].getId() == mNewViewModelList[newItemPosition].getId()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldViewModel = mOldViewModelList[oldItemPosition]
        val newViewModel = mNewViewModelList[newItemPosition]
        return oldViewModel.getName() == newViewModel.getName()
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

}