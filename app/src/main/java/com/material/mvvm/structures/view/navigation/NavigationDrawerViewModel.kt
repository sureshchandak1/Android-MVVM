package com.material.mvvm.structures.view.navigation

import android.app.Activity
import androidx.databinding.ObservableField
import com.material.mvvm.structures.R
import com.material.mvvm.structures.base.adapter.ViewModelItem

class NavigationDrawerViewModel internal constructor(
    private val mActivity: Activity,
    private val mDrawerCallback: NavigationDrawerCallback
) {

    @JvmField
    val navAdapter = ObservableField<NavigationDrawerAdapter>()

    init {
        val adapter = NavigationDrawerAdapter(drawerList)
        navAdapter.set(adapter)
    }

    private val drawerList: MutableList<ViewModelItem>
        get() {
            val viewModels: MutableList<ViewModelItem> = ArrayList()

            var item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_user
            item.title = mActivity.resources.getString(R.string.profile)
            item.from = NavigationDrawerRetention.PROFILE
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_dashboard
            item.title = mActivity.resources.getString(R.string.dashboard)
            item.from = NavigationDrawerRetention.DASHBOARD
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_subscriptions
            item.title = mActivity.resources.getString(R.string.my_subscriptions)
            item.from = NavigationDrawerRetention.MY_SUBSCRIPTIONS
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_ebook
            item.title = mActivity.resources.getString(R.string.my_ebook)
            item.from = NavigationDrawerRetention.MY_EBOOK
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_calendar
            item.title = mActivity.resources.getString(R.string.my_events)
            item.from = NavigationDrawerRetention.MY_EVENT
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_bag
            item.title = mActivity.resources.getString(R.string.store)
            item.from = NavigationDrawerRetention.STORE
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_notification
            item.title = mActivity.resources.getString(R.string.notifications)
            item.from = NavigationDrawerRetention.NOTIFICATION
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_calendar_2
            item.title = mActivity.resources.getString(R.string.upcoming_events)
            item.from = NavigationDrawerRetention.UPCOMING_EVENTS
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_change_password
            item.title = mActivity.resources.getString(R.string.change_password)
            item.from = NavigationDrawerRetention.CHANGE_PASSWORD
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            item = NavigationDrawerItem()
            item.imageId = R.drawable.ic_setting
            item.title = mActivity.resources.getString(R.string.account_settings)
            item.from = NavigationDrawerRetention.ACCOUNT_SETTINGS
            viewModels.add(NavigationDrawerItemViewModel(mActivity, item, mDrawerCallback))

            return viewModels
        }
}