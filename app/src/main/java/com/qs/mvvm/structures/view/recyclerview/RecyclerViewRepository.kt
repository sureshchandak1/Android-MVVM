package com.qs.mvvm.structures.view.recyclerview

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableField
import com.qs.mvvm.structures.R
import com.qs.mvvm.structures.base.adapter.ViewModelItem
import com.qs.mvvm.structures.common.FreeTrialItemViewModel
import com.qs.mvvm.structures.retention.RecyclerViewRetention

class RecyclerViewRepository(private val mActivity: Activity) {

    @JvmField
    val itemDeclaration = ObservableField(RecyclerViewRetention.GRID)

    @JvmField
    val recyclerViewAdapter = ObservableField<RecyclerViewAdapter>()

    @JvmField
    val linearIcon = ObservableField<Drawable>(ContextCompat.getDrawable(mActivity, R.drawable.ic_linear))

    val mCourseList = ArrayList<ViewModelItem>()

    init {
        val adapter = RecyclerViewAdapter(mCourseList)
        recyclerViewAdapter.set(adapter)
    }

    fun linearIconClick(view: View) {
        if (itemDeclaration.get() == RecyclerViewRetention.LINEAR) {
            itemDeclaration.set(RecyclerViewRetention.GRID)
            linearIcon.set(ContextCompat.getDrawable(mActivity, R.drawable.ic_linear))
        } else if (itemDeclaration.get() == RecyclerViewRetention.GRID) {
            itemDeclaration.set(RecyclerViewRetention.LINEAR)
            linearIcon.set(ContextCompat.getDrawable(mActivity, R.drawable.ic_close))
        }
    }

    fun loadLinearCourses() {
        mCourseList.add(RecyclerViewItemViewModel())
        mCourseList.add(RecyclerViewItemViewModel())
        mCourseList.add(FreeTrialItemViewModel(mActivity))
        mCourseList.add(RecyclerViewItemViewModel())
        mCourseList.add(RecyclerViewItemViewModel())
        mCourseList.add(RecyclerViewItemViewModel())
        mCourseList.add(RecyclerViewItemViewModel())
        mCourseList.add(RecyclerViewItemViewModel())
        mCourseList.add(RecyclerViewItemViewModel())
        mCourseList.add(RecyclerViewItemViewModel())
        mCourseList.add(RecyclerViewItemViewModel())

        recyclerViewAdapter.get()?.setList(mCourseList)
    }

    fun loadGridCourses() {
        mCourseList.add(RecyclerViewGridItemViewModel())
        mCourseList.add(RecyclerViewGridItemViewModel())
        mCourseList.add(FreeTrialItemViewModel(mActivity))
        mCourseList.add(RecyclerViewGridItemViewModel())
        mCourseList.add(RecyclerViewGridItemViewModel())
        mCourseList.add(RecyclerViewGridItemViewModel())
        mCourseList.add(RecyclerViewGridItemViewModel())
        mCourseList.add(RecyclerViewGridItemViewModel())
        mCourseList.add(RecyclerViewGridItemViewModel())
        mCourseList.add(RecyclerViewGridItemViewModel())
        mCourseList.add(RecyclerViewGridItemViewModel())

        recyclerViewAdapter.get()?.setList(mCourseList)
    }
}