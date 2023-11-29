package com.capstone.weddingplanner.ui.navigation

sealed class Screen(val route: String){
    object Home: Screen("home")
    object Cart: Screen("cart")
    object Profile: Screen("profile")
    object Vendor: Screen("vendor")
    object Book: Screen("book")
    object DetailReward: Screen("home/{rewardId}") {
        fun createRoute(rewardId: Long) = "home/$rewardId"
    }
}
