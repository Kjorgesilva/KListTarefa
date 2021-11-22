package com.example.klisttarefa.Activity.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tab_registration")
data class Registration(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "activity")
    var activity: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "check")
    var check: Boolean
)