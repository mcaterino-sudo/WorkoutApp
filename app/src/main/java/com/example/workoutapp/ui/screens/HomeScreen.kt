package com.example.workoutapp.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.workoutapp.db.WorkoutEvent
import com.example.workoutapp.db.WorkoutState

@Composable
fun HomeScreen(
    state: WorkoutState, onEvent: (WorkoutEvent) -> Unit
){
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = {  }) {
                
            }
        }
    ){ padding ->
       LazyColumn (
           contentPadding = padding,
           modifier = Modifier.fillMaxSize()
       ){
           items(state.workouts) {workout ->
               Row(
                   modifier = Modifier.fillMaxWidth()
               ){
                   Column(
                       modifier = Modifier.weight(1f)
                   )
                   {
                       Text(
                           text = "${workout.name} ${workout.sets} ${workout.reps} ${workout.weight}",
                           fontSize = 20.sp
                       )
                   }
                   IconButton(onClick = {
                       onEvent(WorkoutEvent.DeleteWorkout(workout))
                   }) {
                       Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Workout")
                   }
               }
          }
       }

    }
}

