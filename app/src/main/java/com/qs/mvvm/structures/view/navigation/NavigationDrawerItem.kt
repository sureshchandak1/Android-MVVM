package com.qs.mvvm.structures.view.navigation

import com.qs.mvvm.structures.view.navigation.NavigationDrawerRetention.NavigationDrawer

data class NavigationDrawerItem (
    var title: String? = null,
    var imageId: Int = 0,
    @NavigationDrawer var from: Int = 0
)