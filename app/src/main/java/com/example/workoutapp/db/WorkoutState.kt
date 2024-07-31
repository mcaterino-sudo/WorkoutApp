package com.example.workoutapp.db

import android.os.Build
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

data class WorkoutState (
    val workouts : List<Workout> = emptyList(),
    val name : String = "",
    val sets : Int = 0,
    val reps : Int = 0,
    val weight : Int = 0,
    val date : LocalDate = LocalDate.now()
)