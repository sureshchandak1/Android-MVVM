package com.qs.mvvm.structures.view.navigation

import androidx.annotation.IntDef

interface NavigationDrawerRetention {

    companion object {
        const val PROFILE = 1
        const val DASHBOARD = 2
        const val MY_SUBSCRIPTIONS = 3
        const val MY_EBOOK = 4
        const val STORE = 5
        const val NOTIFICATION = 6
        const val UPCOMING_EVENTS = 7
        const val ACCOUNT_SETTINGS = 8
        const val CHANGE_PASSWORD = 9
        const val CHAT = 10
        const val LINKED_DEVICE = 11
        const val DELETE_ACCOUNT = 12
        const val REFERRALS_AND_REWARD = 13
        const val SET_PASSWORD = 14
        const val ORDER_HISTORY = 15
        const val OFFER_DETAIL = 16
        const val MY_EVENT = 17
        const val BUY_SUBSCRIPTION = 18
        const val FEEDBACK = 19
        const val TOUR_FACILITY = 20
        const val MY_WISHLIST = 21
        const val APP_THEME = 22
        const val HELP_AND_SUPPORT = 23
    }

    @IntDef(
        PROFILE, DASHBOARD, MY_SUBSCRIPTIONS, MY_EBOOK, STORE, NOTIFICATION,
        UPCOMING_EVENTS, ACCOUNT_SETTINGS, CHANGE_PASSWORD, CHAT, LINKED_DEVICE,
        DELETE_ACCOUNT, REFERRALS_AND_REWARD, SET_PASSWORD, ORDER_HISTORY, OFFER_DETAIL, MY_EVENT,
        BUY_SUBSCRIPTION, FEEDBACK, TOUR_FACILITY, MY_WISHLIST, APP_THEME, HELP_AND_SUPPORT
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class NavigationDrawer
}