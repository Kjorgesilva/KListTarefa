package com.example.klisttarefa.Activity.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.klisttarefa.Activity.repository.model.Registration


@Dao
interface RegistrationDao {

    @Insert
    suspend fun insert(registration: Registration)

    @Delete
    suspend fun delete(registration: Registration)

    @Update
    suspend fun update(registration: Registration)

    @Query("Select * from tab_registration")
    fun getAll(): LiveData<List<Registration>>

    @Query("Select * from tab_registration where id = :key ")
    fun getId(key: Int): Registration
}