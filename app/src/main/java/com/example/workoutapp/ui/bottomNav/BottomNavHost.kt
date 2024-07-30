package com.example.workoutapp.ui.bottomNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.workoutapp.ui.screens.*

@Composable
fun BottomNavHost(navController: NavHostController){
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Calendar.route){
            CalendarScreen()
        }
        composable(BottomNavItem.Home.route){
            HomeScreen()
        }
        composable(BottomNavItem.Graph.route){
            GraphScreen()
        }
    }
}