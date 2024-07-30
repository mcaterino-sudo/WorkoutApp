package com.example.workoutapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WorkoutsDao {
    @Query("SELECT * FROM Workout")
    fun getAll() : List<Workout>

    @Insert
    fun insert(workout: Workout)

    @Delete
    fun delete(workout: Workout)
}