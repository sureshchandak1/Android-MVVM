package com.material.mvvm.structures.view.main

import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.core.view.iterator
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.material.mvvm.structures.AppNavigation
import com.material.mvvm.structures.R
import com.material.mvvm.structures.base.BaseActivity
import com.material.mvvm.structures.databinding.ActivityMainBinding
import com.material.mvvm.structures.extensions.setupWithNavController
import com.material.mvvm.structures.view.navigation.NavigationDrawerFragment

class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mVm: MainViewModel
    private var navController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = MainRepository()
        val factory = MainViewModelFactory(repository)
        mVm = ViewModelProvider(this, factory)[MainViewModel::class.java]
        mBinding.vm = mVm
        mBinding.repository = mVm.mRepository

        if (savedInstanceState == null) {
            setUpNav()
        }

        mBinding.bottomNavigation.itemActiveIndicatorColor = null

        mBinding.bottomNavigation.selectedItemId = R.id.home_nav_graph

        val navigationDrawerFragment = NavigationDrawerFragment.newInstance(mBinding.drawerLayout)
        supportFragmentManager.beginTransaction()
            .add(R.id.navigationView, navigationDrawerFragment).commit()
    }

    private fun setUpNav() {

        val graphIds = listOf(
            R.navigation.home_nav_graph,
            R.navigation.my_courses_nav_graph,
            R.navigation.explore_nav_graph,
            R.navigation.events_nav_graph,
            R.navigation.profile_nav_graph
        )

        val controller = mBinding.bottomNavigation.setupWithNavController(
            graphIds,
            supportFragmentManager,
            R.id.nav_host_fragment,
            intent
        )

        controller.observe(this) {
            it.addOnDestinationChangedListener(navDestinationListener)
        }
        navController = controller
    }

    private val navDestinationListener =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.homeFragment -> updateUI(resources.getString(R.string.home),
                    isBack = false,
                    hideBottomNav = false,
                    menuItemInvisibleIndex = intArrayOf()
                )
                R.id.myCoursesFragment -> updateUI(resources.getString(R.string.my_courses),
                    isBack = false,
                    hideBottomNav = false,
                    menuItemInvisibleIndex = intArrayOf()
                )
                R.id.exploreFragment -> updateUI(resources.getString(R.string.courses),
                    isBack = false,
                    hideBottomNav = false,
                    menuItemInvisibleIndex = intArrayOf()
                )
                R.id.eventsFragment -> updateUI(resources.getString(R.string.events),
                    isBack = false,
                    hideBottomNav = false,
                    menuItemInvisibleIndex = intArrayOf()
                )
                R.id.profileFragment -> updateUI(resources.getString(R.string.profile),
                    isBack = false,
                    hideBottomNav = false,
                    menuItemInvisibleIndex = intArrayOf()
                )
                R.id.loginFragment -> updateUI("",
                    isBack = true,
                    hideBottomNav = true,
                    menuItemInvisibleIndex = intArrayOf()
                )
                R.id.recyclerViewFragment -> updateUI(resources.getString(R.string.recyclerview),
                    isBack = true,
                    hideBottomNav = true,
                    menuItemInvisibleIndex = intArrayOf()
                )
                else -> {}
            }
        }

    private fun updateUI(
        title: String,
        isBack: Boolean = false,
        hideBottomNav: Boolean = false,
        vararg menuItemInvisibleIndex: Int
    ) {
        mVm.mRepository.title.set(title)
        mVm.mRepository.bottomNavVisibility.set(true)

        for (item: MenuItem in mBinding.toolbar.menu.iterator()) {
            item.isVisible = true
        }

        for (index in menuItemInvisibleIndex) {
            mBinding.toolbar.menu[index].isVisible = false
        }

        if (hideBottomNav) {
            mVm.mRepository.bottomNavVisibility.set(false)
        } else {
            mVm.mRepository.bottomNavVisibility.set(true)
        }

        if (isBack) {
            mBinding.toolbar.navigationIcon =
                ContextCompat.getDrawable(this, R.drawable.ic_arrow_back)
            mBinding.toolbar.setNavigationOnClickListener { AppNavigation.navigateUp(navController?.value!!) }
        } else {
            mBinding.toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_nav_drawer)
            mBinding.toolbar.setNavigationOnClickListener {
                mBinding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
    }
}