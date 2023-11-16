package com.qs.mvvm.structures.view.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.qs.mvvm.structures.R
import com.qs.mvvm.structures.common.FreeTrialItemViewModel
import com.qs.mvvm.structures.databinding.FragmentRecyclerViewBinding
import com.qs.mvvm.structures.retention.RecyclerViewRetention

class RecyclerViewFragment : Fragment() {

    private lateinit var mBinding: FragmentRecyclerViewBinding
    private lateinit var mVm: RecyclerViewViewModel
    private lateinit var mGridLayoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycler_view, container, false)

        val repository = RecyclerViewRepository(requireActivity())
        mVm = RecyclerViewViewModel(repository)
        mBinding.vm = mVm
        mBinding.repository = mVm.mRepository

        with(mBinding) {
            paidRecyclerView.isNestedScrollingEnabled = true
            mGridLayoutManager = GridLayoutManager(requireContext(), 2)
            paidRecyclerView.layoutManager = mGridLayoutManager
        }

        mGridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val adapter: RecyclerViewAdapter? = mVm.mRepository.recyclerViewAdapter.get()
                if (adapter != null) {
                    val viewModels = adapter.getList()
                    if (viewModels[position] is FreeTrialItemViewModel) {
                        return 2
                    } else if (viewModels[position] is RecyclerViewGridItemViewModel) {
                        return 1
                    }
                }
                return -1
            }
        }

        mVm.mRepository.itemDeclaration.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {

            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if (mVm.mRepository.itemDeclaration.get() == RecyclerViewRetention.LINEAR) {
                    mBinding.paidRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                    mVm.mRepository.mCourseList.clear()
                    mVm.mRepository.loadLinearCourses()
                } else if (mVm.mRepository.itemDeclaration.get() == RecyclerViewRetention.GRID) {
                    mBinding.paidRecyclerView.layoutManager = mGridLayoutManager
                    mVm.mRepository.mCourseList.clear()
                    mVm.mRepository.loadGridCourses()
                }
            }

        })

        return mBinding.root
    }

}