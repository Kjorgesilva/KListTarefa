package com.example.klisttarefa.Activity.ui.registration

import android.content.Context
import android.util.Log
import com.example.klisttarefa.Activity.repository.dataBase.RegistrationDataBase
import com.example.klisttarefa.Activity.repository.model.Registration
import com.example.klisttarefa.Activity.repository.repository.RegistrationRepository

class RegistrationViewModel {

    lateinit var registrationRepository: RegistrationRepository

    fun initViewModel(context: Context) {
        registrationRepository = RegistrationRepository(RegistrationDataBase.getInstance(context).registrationDao)
    }

    suspend fun addRegistry(registration: Registration) {
        registrationRepository.save(registration)
        Log.e("add", "Add Registro: " + registration.toString())
    }

}