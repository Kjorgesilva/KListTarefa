package com.example.klisttarefa.Activity.repository.viewModelRepository

import androidx.lifecycle.LiveData
import com.example.klisttarefa.Activity.repository.dao.RegistrationDao
import com.example.klisttarefa.Activity.repository.model.Registration

class RegistrationRepository(val registrationDao: RegistrationDao){

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

    suspend fun getAllProjet(): List<Registration> {
        return registrationDao.getAllProjet()
    }

}