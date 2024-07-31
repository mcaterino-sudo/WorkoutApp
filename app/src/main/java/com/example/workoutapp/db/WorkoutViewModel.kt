package com.example.workoutapp.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

class WorkoutsViewModel(private val dao : WorkoutDao) : ViewModel(){

    private val _state = MutableStateFlow(WorkoutState())
    private val _workouts = dao.getAll()

    val state = combine(_state, _workouts) { state, workouts ->
        state.copy(workouts = workouts)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), WorkoutState())

    fun onEvent(event: WorkoutEvent) {
        when(event) {
            is WorkoutEvent.DeleteWorkout -> { dao.delete(event.workout) }
            WorkoutEvent.SaveWorkout -> {
                val name = state.value.name
                val reps = state.value.reps
                val sets = state.value.sets
                val weight = state.value.weight
                val date = state.value.date

                if(name.isBlank() || reps == 0 || sets == 0 || weight == 0 || date == LocalDate.now()){
                    return
                }

                val workout = Workout(
                    name = name,
                    reps = reps,
                    sets = sets,
                    weight = weight,
                    date = date
                )
                viewModelScope.launch { dao.insert(workout) }
                _state.update{ it.copy(
                    name = "",
                    reps = 0,
                    sets = 0,
                    weight = 0,
                    date = LocalDate.now()
                )}
            }
            is WorkoutEvent.SetDate -> { _state.update { it.copy(date = event.date) }}
            is WorkoutEvent.SetName -> { _state.update { it.copy(name = event.name) }}
            is WorkoutEvent.SetReps -> { _state.update { it.copy(reps = event.reps) }}
            is WorkoutEvent.SetSets -> { _state.update { it.copy(sets = event.sets) }}
            is WorkoutEvent.SetWeight -> { _state.update { it.copy(weight = event.weight) }}
        }
    }
}