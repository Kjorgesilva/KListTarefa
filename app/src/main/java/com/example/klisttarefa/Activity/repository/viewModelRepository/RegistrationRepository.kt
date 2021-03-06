package com.example.klisttarefa.Activity.repository.viewModelRepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.klisttarefa.Activity.repository.dao.RegistrationDao
import com.example.klisttarefa.Activity.repository.model.Registration


class RegistrationRepository(private var registrationDao: RegistrationDao): ViewModel(){


    val registration : LiveData<List<Registration>>
    get()= registrationDao.getAll()

    suspend fun save(newRegistration: Registration){
        registrationDao.insert(newRegistration)
    }

    suspend fun update(newRegistration: Registration){
        registrationDao.update(newRegistration)
    }

    suspend fun delete(newRegistration: Registration){
        registrationDao.insert(newRegistration)
    }

    fun getId(newRegistration: Registration){
        registrationDao.getId(newRegistration.id)
    }

}