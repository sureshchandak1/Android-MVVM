package com.material.mvvm.structures.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.material.mvvm.structures.R
import com.material.mvvm.structures.base.BaseFragment
import com.material.mvvm.structures.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var mVm: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val repository = HomeRepository()
        val factory = HomeViewModelFactory(repository)
        mVm = ViewModelProvider(this, factory)[HomeViewModel::class.java]
        mBinding.vm = mVm
        mBinding.repository = mVm.mRepository

        return mBinding.root
    }

}