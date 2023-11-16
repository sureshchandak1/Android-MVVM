package com.material.mvvm.structures.view.login

import android.view.View
import com.material.mvvm.structures.AppNavigation
import com.material.mvvm.structures.base.BaseViewModel

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