package com.example.klisttarefa.Activity.repository.repository

import com.example.klisttarefa.Activity.repository.dao.RegistrationDao
import com.example.klisttarefa.Activity.repository.model.Registration

class RegistrationRepository(val registrationDao: RegistrationDao){

    suspend fun save(newRegistration: Registration){
        registrationDao.insert(newRegistration)
    }

    suspend fun update(registration: Registration){
        registrationDao.update(registration)
    }

    suspend fun delete(registration: Registration){
        registrationDao.delete(registration)
    }

    fun getId(registration: Registration){
        registrationDao.getId(registration.id)
    }

    suspend fun getAllRegistrations(): List<Registration> {
        return registrationDao.getAllProjet()
    }

}