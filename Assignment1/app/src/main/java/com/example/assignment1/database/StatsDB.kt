package com.example.assignment1.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Stats::class],version = 1)
abstract class StatsDB :RoomDatabase() {
    abstract fun statsDao():StatsDao
}