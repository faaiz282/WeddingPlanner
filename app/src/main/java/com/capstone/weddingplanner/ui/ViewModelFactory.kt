package com.capstone.weddingplanner.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capstone.weddingplanner.data.RewardRepository
import com.capstone.weddingplanner.ui.screen.cart.CartViewModel
import com.capstone.weddingplanner.ui.screen.detail.DetailRewardViewModel
import com.capstone.weddingplanner.ui.screen.home.HomeViewModel
import com.capstone.weddingplanner.ui.screen.vendor.VendorViewModel

class ViewModelFactory(private val repository: RewardRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailRewardViewModel::class.java)) {
            return DetailRewardViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            return CartViewModel(repository) as T
        }else if (modelClass.isAssignableFrom(VendorViewModel::class.java)){
            return VendorViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}