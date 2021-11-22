package com.example.klisttarefa.Activity.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.klisttarefa.Activity.repository.model.Registration
import com.example.klisttarefa.Activity.repository.viewModelRepository.RegistrationRepository
import com.example.klisttarefa.R
import com.example.klisttarefa.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.launch

class RegistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrationBinding
    lateinit var registrationRepository: RegistrationRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val binding = ActivityRegistrationBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.btnSalvar.setOnClickListener {
            lifecycleScope.launch { addRegistro() }
        }


    }

    suspend fun addRegistro() {
        val registration = Registration(3, "teste", "teste", false)
        registrationRepository.save(registration)
        Log.e("add", "Add Registro: " + registration.toString())
    }
}