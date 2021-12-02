package com.example.klisttarefa.Activity.ui.registration

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.klisttarefa.Activity.repository.dataBase.RegistrationDataBase
import com.example.klisttarefa.Activity.repository.model.Registration
import com.example.klisttarefa.Activity.repository.repository.RegistrationRepository

class RegistrationViewModel(
    dataBase: RegistrationDataBase
) : ViewModel() {

    private val _registrationState = MutableLiveData<RegistrationState>()
    val registrationState = _registrationState

    var registrationRepository = RegistrationRepository(dataBase.registrationDao)

    suspend fun addRegistry(text: String, type: String) {
        if (text.isNotEmpty() && type.isNotEmpty()) {
            val registration = Registration(
                activity = text,
                type = type,
                check = false
            )
            Log.e("add", "Add Registro: " + registration.toString())
            saveRegistration(registration)
        } else {
            _registrationState.value = RegistrationState.Empty
        }
    }

    private suspend fun saveRegistration(registration: Registration) {
        try {
            registrationRepository.save(registration)
            _registrationState.value = RegistrationState.Success
        } catch (e: Exception) {
            Log.e("Erro", "Mensagem: " + e)
            _registrationState.value = RegistrationState.Error
        }
    }

    sealed class RegistrationState {
        object Success : RegistrationState()
        object Error : RegistrationState()
        object Empty : RegistrationState()
    }
}