package com.example.assignment1.database

import androidx.room.*

@Dao
interface StatsDao {
    @Query("SELECT * FROM stats where uid = 1")
    fun getAll():Stats
    @Query("Delete from stats where uid > 1") //hehehe so this isn't important don't worry about it
    fun delete()
    @Insert
    fun insert(vararg stats: Stats)
    @Update(entity = Stats::class)
    fun updateInfo(vararg info: Stats)



}