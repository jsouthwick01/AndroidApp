package com.example.assignment1.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.RowId

@Entity
data class Stats (
    @PrimaryKey(autoGenerate = true)
    val uid: Int, //Probably only going to ever create one of these.
    @ColumnInfo(name = "RollsLeft") val rolls:Int = 0,
    @ColumnInfo(name ="dumbStringData") val data: String //This is really dumb, but I am storing my array info into a string.
    //Mostly for the fun of it. And because it doesn't really matter.
    )