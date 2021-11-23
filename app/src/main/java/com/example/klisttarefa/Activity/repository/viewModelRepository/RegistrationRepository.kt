package com.example.klisttarefa.Activity.repository.viewModelRepository

import android.widget.ListView
import androidx.lifecycle.LiveData
import com.example.klisttarefa.Activity.repository.dao.RegistrationDao
import com.example.klisttarefa.Activity.repository.model.Registration

data class RegistrationRepository(val registrationDao: RegistrationDao){

    val registration : LiveData<List<Registration>>
    get()= registrationDao.getAll()

    suspend fun save(newRegistration: Registration){
        registrationDao.insert(newRegistration)
    }

    suspend fun update(newRegistration: Registration){
        registrationDao.update(newRegistration)
    }

    suspend fun delete(newRegistration: Registration){
        registrationDao.delete(newRegistration)
    }

    fun getId(newRegistration: Registration){
        registrationDao.getId(newRegistration.id)
    }

    fun getAll() {
        registrationDao.getAll()
    }
}