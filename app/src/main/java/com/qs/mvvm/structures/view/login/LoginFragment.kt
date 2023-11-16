package com.qs.mvvm.structures.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.qs.mvvm.structures.R
import com.qs.mvvm.structures.base.BaseFragment
import com.qs.mvvm.structures.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment() {

    private lateinit var mBinding: FragmentLoginBinding
    private lateinit var mVm: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        val repository = LoginRepository(requireActivity())
        val factory = LoginViewModelFactory(repository)
        mVm = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        mBinding.vm = mVm
        mBinding.repository = mVm.mRepository

        return mBinding.root
    }


}