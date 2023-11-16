package com.material.mvvm.structures.view.navigation

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.material.mvvm.structures.R
import com.material.mvvm.structures.base.adapter.ViewModelItem

class NavigationDrawerItemViewModel internal constructor(
    private val mActivity: Activity,
    item: NavigationDrawerItem,
    private val mDrawerCallback: NavigationDrawerCallback
) : ViewModelItem {

    @JvmField
    val drawerItem = ObservableField<NavigationDrawerItem>()

    @JvmField
    val isShowImage = ObservableBoolean(true)

    init {
        drawerItem.set(item)
        if (item.imageId == 0) {
            isShowImage.set(false)
        }
    }

    fun itemClick(view: View) {
        val bundle = Bundle()
        val navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment)
        Handler(Looper.getMainLooper()).postDelayed({ mDrawerCallback.closeDrawer() }, 100)
        when (drawerItem.get()!!.from) {
            NavigationDrawerRetention.PROFILE -> {

            }
            NavigationDrawerRetention.DASHBOARD -> {

            }
            NavigationDrawerRetention.MY_SUBSCRIPTIONS -> {

            }
            NavigationDrawerRetention.BUY_SUBSCRIPTION -> {

            }
            NavigationDrawerRetention.MY_EBOOK -> {

            }
            NavigationDrawerRetention.MY_EVENT -> {

            }
            NavigationDrawerRetention.STORE -> {
                mDrawerCallback.selectBottomNav(R.id.explore_nav_graph)
            }
            NavigationDrawerRetention.NOTIFICATION -> {

            }
            NavigationDrawerRetention.UPCOMING_EVENTS -> {}
            NavigationDrawerRetention.CHANGE_PASSWORD -> {

            }
            NavigationDrawerRetention.ACCOUNT_SETTINGS -> {}
            NavigationDrawerRetention.CHAT -> {}
            NavigationDrawerRetention.LINKED_DEVICE -> {

            }
            NavigationDrawerRetention.DELETE_ACCOUNT -> {

            }
            NavigationDrawerRetention.REFERRALS_AND_REWARD -> {

            }
            NavigationDrawerRetention.SET_PASSWORD -> {

            }
            NavigationDrawerRetention.ORDER_HISTORY -> {

            }
            NavigationDrawerRetention.OFFER_DETAIL -> {

            }
            NavigationDrawerRetention.FEEDBACK -> {

            }
            NavigationDrawerRetention.MY_WISHLIST -> {

            }
            NavigationDrawerRetention.APP_THEME -> {

            }
            NavigationDrawerRetention.HELP_AND_SUPPORT -> {

            }
        }
    }

    private fun loadFragment(navController: NavController, loadFragmentId: Int, bundle: Bundle) {
        if (navController.currentDestination!!.id != loadFragmentId) {
            navController.navigate(loadFragmentId, bundle)
        }
    }

    override fun close() {}
}