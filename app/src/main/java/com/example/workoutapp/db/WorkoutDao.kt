package com.example.workoutapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM Workout")
    fun getAll() : Flow<List<Workout>>

    @Query("SELECT * FROM Workout WHERE date = DATE('now')")
    fun getToday() : Flow<List<Workout>>

    @Insert
    fun insert(workout: Workout)

    @Delete
    fun delete(workout: Workout)
}