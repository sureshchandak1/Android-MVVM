package com.qs.mvvm.structures.view.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.qs.mvvm.structures.R
import com.qs.mvvm.structures.databinding.FragmentNavigationDrawerBinding

class NavigationDrawerFragment : Fragment, NavigationDrawerCallback {

    private lateinit var mBinding: FragmentNavigationDrawerBinding
    private lateinit var mVm: NavigationDrawerViewModel
    private lateinit var mDrawerToggle: ActionBarDrawerToggle
    private lateinit var mDrawerLayout: DrawerLayout

    constructor() {}

    constructor(drawerLayout: DrawerLayout) {
        mDrawerLayout = drawerLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_navigation_drawer, container, false)

        mBinding.recyclerView.isNestedScrollingEnabled = false

        mVm = NavigationDrawerViewModel(requireActivity(), this)
        mBinding.vm = mVm

        mBinding.closeImage.setOnClickListener { toggleDrawer() }

        return mBinding.root
    }

    private fun refreshNav() {}

    fun setUpDrawer(fragmentId: Int, drawerLayout: DrawerLayout, toolbar: Toolbar?) {
        mDrawerLayout = drawerLayout
        mDrawerToggle = object : ActionBarDrawerToggle(
            activity,
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ) {

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                refreshNav()
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                //                getActivity().invalidateOptionsMenu();
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
            }
        }

        mDrawerLayout.addDrawerListener(mDrawerToggle)

        // sync the state of Navigation Drawer with the help of Runnable
        mDrawerLayout.post { mDrawerToggle.syncState() }
    }

    private fun toggleDrawer() {
        if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun closeDrawer() {
        toggleDrawer()
    }

    override fun selectBottomNav(id: Int) {

    }

    companion object {
        fun newInstance(drawerLayout: DrawerLayout): NavigationDrawerFragment {
            val fragment = NavigationDrawerFragment(drawerLayout)
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}