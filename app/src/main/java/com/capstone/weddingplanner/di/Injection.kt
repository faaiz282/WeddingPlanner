package com.capstone.weddingplanner.di

import com.capstone.weddingplanner.data.RewardRepository

object Injection {
    fun provideRepository(): RewardRepository {
        return RewardRepository.getInstance()
    }
}