package com.example.klisttarefa.Activity.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import com.example.klisttarefa.Activity.repository.dataBase.RegistrationDataBase
import com.example.klisttarefa.Activity.repository.model.Registration
import com.example.klisttarefa.Activity.repository.viewModelRepository.RegistrationRepository
import com.example.klisttarefa.R
import com.example.klisttarefa.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.launch

class RegistrationActivity : AppCompatActivity() {


    lateinit var registrationRepository: RegistrationRepository
    private val binding by lazy { ActivityRegistrationBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val view = binding.root
        setContentView(view)

        registrationRepository = RegistrationRepository(RegistrationDataBase.getInstance(this).registrationDao)

        binding.btnSalvar.setOnClickListener {
            lifecycleScope.launch { addRegistro() }
        }
    }

    suspend fun addRegistro() {
        try {
            if (!binding.edtActivity.text.toString().isEmpty() && !binding.edtType.text.toString()
                    .isEmpty()
            ) {
                var registration = Registration(
                    activity = binding.edtActivity.text.toString(),
                    type = binding.edtType.text.toString(),
                    check = false
                )
                registrationRepository.save(registration)
                Log.e("add", "Add Registro: " + registration.toString())
                finish()
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }

        } catch (e: Exception) {
            Log.e("Erro", "Mensagem: " + e)
        }
    }
}