package com.qs.mvvm.structures.view.home

import com.qs.mvvm.structures.base.BaseViewModel

class HomeViewModel(repository: HomeRepository) : BaseViewModel() {

    val mRepository: HomeRepository

    init {
        mRepository = repository
    }

}