package com.example.klisttarefa.Activity.repository.dao

import androidx.room.*
import com.example.klisttarefa.Activity.repository.model.Registration

@Dao
interface RegistrationDao {
    companion object {
        const val QUERY_REGISTRATION  = "Select * from tab_registration"
        const val QUERY_REGISTRATION_ID = "Select * from tab_registration where id = :key "
    }
    @Insert
    suspend fun insert(registration: Registration)

    @Delete
    suspend fun delete(registration: Registration)

    @Update
    suspend fun update(registration: Registration)

    @Query(QUERY_REGISTRATION)
    suspend fun getAllProjet(): List<Registration>

    @Query(QUERY_REGISTRATION_ID)
    fun getId(key: Int): Registration
}