package com.material.mvvm.structures.view.recyclerview

class RecyclerViewViewModel(repository: RecyclerViewRepository) {

    val mRepository: RecyclerViewRepository

    init {
        mRepository = repository

        loadPaidCourses()
    }

    private fun loadPaidCourses() {
        mRepository.loadGridCourses()
    }
}