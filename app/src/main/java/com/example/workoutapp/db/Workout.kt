package com.example.workoutapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

@Entity
data class Workout(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo val name : String,
    @ColumnInfo val sets : Int,
    @ColumnInfo val reps : Int,
    @ColumnInfo val weight : Int,
    @ColumnInfo val date : LocalDate
)