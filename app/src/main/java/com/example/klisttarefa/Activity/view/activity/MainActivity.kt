package com.example.klisttarefa.Activity.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klisttarefa.Activity.repository.dataBase.RegistrationDataBase
import com.example.klisttarefa.Activity.view.adapter.AdapterList
import com.example.klisttarefa.Activity.repository.model.Registration
import com.example.klisttarefa.Activity.repository.repository.RegistrationRepository
import com.example.klisttarefa.Activity.ui.registration.RegistrationActivity
import com.example.klisttarefa.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var registration: ArrayList<Registration>
    private lateinit var registrationTrue: ArrayList<Registration>
    private lateinit var registrationFalse: ArrayList<Registration>
    private lateinit var adapter: RecyclerView.Adapter<AdapterList.ItemViewHolder>
    private lateinit var registrationRepository: RegistrationRepository
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //add linha teste

        registration = ArrayList()
        registrationTrue = ArrayList()
        registrationFalse = ArrayList()

        registrationRepository = RegistrationRepository(RegistrationDataBase.getInstance(this).registrationDao)

      lifecycleScope.launch { listActivity() }

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java).apply {}
            startActivity(intent)
        }
    }
    suspend fun listActivity(){
        try {
            registrationRepository.getAllRegistrations().forEach {
                val layout = LinearLayoutManager(this)
                if (it.check) {
                    binding.rvCompleted.layoutManager = layout
                    registrationTrue.add(it)
                    adapter = AdapterList(registrationTrue, this)
                    binding.rvCompleted.adapter = adapter
                } else {
                    binding.rvIncomplete.layoutManager = layout
                    registrationFalse.add(it)
                    adapter = AdapterList(registrationFalse, this)
                    binding.rvIncomplete.adapter = adapter
                }
            }
        } catch (e: Exception) {
            Log.e("t", "valor null" + e)
        }
    }
}