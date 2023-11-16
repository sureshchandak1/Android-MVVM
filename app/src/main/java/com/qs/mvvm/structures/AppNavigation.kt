package com.qs.mvvm.structures

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.navOptions

object AppNavigation {

    fun navigate(activity: Activity, loadFragmentId: Int, bundle: Bundle) {
        val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
        if (navController.currentDestination!!.id != loadFragmentId) {
            navController.navigate(loadFragmentId, bundle, navOptions { // Kotlin DSL for building NavOptions
                anim {
                    enter = R.anim.slide_in_from_right
                    exit = R.anim.slide_out_to_left
                }
                launchSingleTop = true
            })
        }
    }

    fun navigate(view: View, actionId: Int, bundle: Bundle) {
        val navController = Navigation.findNavController(view)
        if (navController.currentDestination!!.id != actionId) {
            navController.navigate(actionId, bundle, navOptions {
                anim {
                    enter = R.anim.slide_in_from_right
                    exit = R.anim.slide_out_to_left
                }
                launchSingleTop = true
            })
        }
    }

    fun navigate(activity: Activity, navDirections: NavDirections) {
        val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
        navController.navigate(navDirections, navOptions { // Kotlin DSL for building NavOptions
            anim {
                enter = R.anim.slide_in_from_right
                exit = R.anim.slide_out_to_left
            }
            launchSingleTop = true
        })
    }

    fun navigate(view: View, navDirections: NavDirections) {
        val navController = Navigation.findNavController(view)
        navController.navigate(navDirections, navOptions { // Kotlin DSL for building NavOptions
            anim {
                enter = R.anim.slide_in_from_right
                exit = R.anim.slide_out_to_left
            }
            launchSingleTop = true
        })
    }

    fun popBackStack(activity: Activity) {
        val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
        navController.popBackStack()
    }

    fun popBackStack(activity: Activity, id: Int, inclusive: Boolean = false) {
        val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
        navController.popBackStack(id, inclusive)
    }

    fun navigateUp(view: View) {
        Navigation.findNavController(view).navigateUp()
    }

    fun navigateUp(activity: Activity) {
        val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
        navController.navigateUp()
    }

    fun navigateUp(navController: NavController) {
        navController.navigateUp()
    }

}