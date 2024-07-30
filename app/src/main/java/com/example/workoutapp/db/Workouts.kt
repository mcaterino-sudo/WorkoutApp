package com.example.workoutapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Workout(
    @PrimaryKey val id : Int,
    @ColumnInfo val name : String,
    @ColumnInfo val sets : Int,
    @ColumnInfo val reps : Int,
    @ColumnInfo val weight : Int,
    @ColumnInfo val date : Date
)