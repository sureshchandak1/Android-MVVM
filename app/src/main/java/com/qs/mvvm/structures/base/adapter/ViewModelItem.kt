package com.qs.mvvm.structures.base.adapter

interface ViewModelItem {

    fun getId(): String {
        return ""
    }

    fun getName(): String {
        return ""
    }

    fun close() {}
}