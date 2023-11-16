package com.qs.mvvm.structures.view.main

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

class MainRepository {

    @JvmField
    val title = ObservableField("MVVM")

    @JvmField
    val bottomNavVisibility = ObservableBoolean(true)

}