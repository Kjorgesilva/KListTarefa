package com.example.klisttarefa.Activity.repository.dao

import androidx.room.*
import com.example.klisttarefa.Activity.constants.Constants
import com.example.klisttarefa.Activity.repository.model.Registration


@Dao
interface RegistrationDao {


    @Insert
    suspend fun insert(registration: Registration)

    @Delete
    suspend fun delete(registration: Registration)

    @Update
    suspend fun update(registration: Registration)

    @Query(Constants.QUERY_REGISTRATION)
    suspend fun getAllProjet(): List<Registration>

    @Query(Constants.QUERY_REGISTRATION_ID)
    fun getId(key: Int): Registration
}