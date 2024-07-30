package com.example.workoutapp.ui.bottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Calendar : BottomNavItem("calendar", Icons.Default.DateRange, "Calendar")
    object Graph : BottomNavItem("graph", Icons.AutoMirrored.Filled.List, "Graph")

    companion object {
        fun getBottomNavItems() : List<BottomNavItem> {
            return listOf(
                Calendar,
                Home,
                Graph
            )
        }
    }
}

