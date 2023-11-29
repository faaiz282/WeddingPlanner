package com.capstone.weddingplanner.ui.screen.cart

import com.capstone.weddingplanner.model.OrderReward

data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)