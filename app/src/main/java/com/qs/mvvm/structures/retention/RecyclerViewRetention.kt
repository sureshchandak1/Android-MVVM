package com.qs.mvvm.structures.retention

import androidx.annotation.IntDef

interface RecyclerViewRetention {

    companion object {
        const val NONE = 0
        const val LINEAR = 1
        const val GRID = 2
    }

    @IntDef(NONE, LINEAR, GRID)
    @Retention(AnnotationRetention.SOURCE)
    annotation class RecyclerView

}