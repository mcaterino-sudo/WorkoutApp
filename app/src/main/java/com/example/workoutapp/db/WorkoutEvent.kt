package com.example.workoutapp.db

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

sealed interface WorkoutEvent {
    object SaveWorkout : WorkoutEvent
    data class SetName(val name : String) : WorkoutEvent
    data class SetSets(val sets : Int) : WorkoutEvent
    data class SetReps(val reps : Int) : WorkoutEvent
    data class SetWeight(val weight : Int) : WorkoutEvent
    data class SetDate(val date : LocalDate) : WorkoutEvent

    data class DeleteWorkout(val workout: Workout) : WorkoutEvent
}