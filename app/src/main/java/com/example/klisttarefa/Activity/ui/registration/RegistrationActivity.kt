package com.example.klisttarefa.Activity.ui.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.klisttarefa.Activity.repository.dataBase.RegistrationDataBase
import com.example.klisttarefa.Activity.repository.model.Registration
import com.example.klisttarefa.Activity.repository.repository.RegistrationRepository
import com.example.klisttarefa.R
import com.example.klisttarefa.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.launch

class RegistrationActivity : AppCompatActivity() {

    lateinit var viewModel: RegistrationViewModel
    private val binding by lazy { ActivityRegistrationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setContentView(binding.root)

        viewModel = RegistrationViewModel()
        viewModel.initViewModel(this)

        binding.btnSalvar.setOnClickListener {
            lifecycleScope.launch { addRegistry() }
        }
    }

    suspend fun addRegistry() {
        try {
            if (binding.edtActivity.text.isNotEmpty() && binding.edtType.text.isNotEmpty()) {
                val registration = Registration(
                    activity = binding.edtActivity.text.toString(),
                    type = binding.edtType.text.toString(),
                    check = false
                )

                viewModel.addRegistry(registration)
                finish()
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Log.e("Erro", "Mensagem: " + e)
        }
    }
}