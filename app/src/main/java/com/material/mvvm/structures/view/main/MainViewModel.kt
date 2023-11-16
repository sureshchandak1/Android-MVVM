package com.material.mvvm.structures.view.main

import com.material.mvvm.structures.base.BaseViewModel

class MainViewModel(repository: MainRepository) : BaseViewModel() {

    val mRepository: MainRepository

    init {
        mRepository = repository
    }

}