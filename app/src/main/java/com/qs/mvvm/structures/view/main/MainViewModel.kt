package com.qs.mvvm.structures.view.main

import com.qs.mvvm.structures.base.BaseViewModel

class MainViewModel(repository: MainRepository) : BaseViewModel() {

    val mRepository: MainRepository

    init {
        mRepository = repository
    }

}