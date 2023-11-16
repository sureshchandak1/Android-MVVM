package com.qs.mvvm.structures.view.login

import android.view.View
import com.qs.mvvm.structures.AppNavigation
import com.qs.mvvm.structures.base.BaseViewModel

class LoginViewModel(repository: LoginRepository) : BaseViewModel() {

    val mRepository: LoginRepository

    init {
        mRepository = repository
    }

    fun loginClick(view: View) {
        if (mRepository.validation()) {
            AppNavigation.navigateUp(view)
        }
    }

}