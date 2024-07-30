package com.example.workoutapp

import android.annotation.SuppressLint
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.workoutapp.ui.bottomNav.BottomNavBar
import com.example.workoutapp.ui.bottomNav.BottomNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController){
    Scaffold (bottomBar = {
        BottomAppBar {
            BottomNavBar(navController = navController)
        }
    }) {
        BottomNavHost(navController = navController)
    }
}