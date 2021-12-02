package com.example.klisttarefa.Activity.ui.registration

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.klisttarefa.Activity.repository.dataBase.RegistrationDataBase
import com.example.klisttarefa.R
import com.example.klisttarefa.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.launch

class RegistrationActivity : AppCompatActivity() {

    lateinit var dataBase: RegistrationDataBase

    lateinit var viewModel: RegistrationViewModel
    private val binding by lazy { ActivityRegistrationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setContentView(binding.root)

        dataBase = RegistrationDataBase.getInstance(this)
        viewModel = RegistrationViewModel(dataBase)

        setupListeners()
        setupObservers()
    }

    private fun setupListeners() = with(binding) {
        btnSalvar.setOnClickListener {
            lifecycleScope.launch { addRegistry() }
        }
    }

    private fun setupObservers() {
        viewModel.registrationState.observe(this, { registration ->
            when (registration) {
                RegistrationViewModel.RegistrationState.Success -> finish()
                RegistrationViewModel.RegistrationState.Error -> showError()
                RegistrationViewModel.RegistrationState.Empty-> showEmptyError()
            }
        })
    }

    private suspend fun addRegistry() = with(binding) {
        viewModel.addRegistry(
            text = edtActivity.text.toString(),
            type = edtType.text.toString()
        )
    }

    private fun showError() {
        Toast.makeText(this, "Erro ao salvar no banco", Toast.LENGTH_LONG).show()
    }

    private fun showEmptyError() {
        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
    }
}