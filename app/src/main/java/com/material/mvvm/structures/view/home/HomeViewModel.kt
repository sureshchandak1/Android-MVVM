package com.material.mvvm.structures.view.home

import com.material.mvvm.structures.base.BaseViewModel

class HomeViewModel(repository: HomeRepository) : BaseViewModel() {

    val mRepository: HomeRepository

    init {
        mRepository = repository
    }

}