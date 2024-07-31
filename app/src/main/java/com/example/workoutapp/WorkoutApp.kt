package com.example.workoutapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.workoutapp.db.WorkoutDatabase

@Composable
fun WorkoutApp(){
    val navController = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize()) {
        MainScreen(navController = navController)
    }
}

@Preview
@Composable
fun Prev(){
    val navController = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize()) {
        MainScreen(navController = navController)
    }
}