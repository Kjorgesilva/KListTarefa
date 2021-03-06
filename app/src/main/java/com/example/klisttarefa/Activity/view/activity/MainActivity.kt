package com.example.klisttarefa.Activity.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klisttarefa.Activity.view.adapter.AdapterList
import com.example.klisttarefa.Activity.repository.model.Registration
import com.example.klisttarefa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var registration: ArrayList<Registration>
    private lateinit var registrationTrue: ArrayList<Registration>
    private lateinit var registrationFalse: ArrayList<Registration>
    private lateinit var adapter: RecyclerView.Adapter<AdapterList.ItemViewHolder>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)


        registration = ArrayList()
        registrationTrue = ArrayList()
        registrationFalse = ArrayList()


        val registrationOne = Registration(1,"Go to the gym", "Sport", true)
        val registrationTwo = Registration(2,"Go to school", "study", false)


        registration.add(registrationOne)
        registration.add(registrationTwo)

        for (itens in registration) {
            if (itens.check == true) {
                val layout = LinearLayoutManager(this)
                binding.rvCompleted.layoutManager = layout
                registrationTrue.add(itens)
                adapter = AdapterList(registrationTrue, this)
                binding.rvCompleted.adapter = adapter
            } else {
                val layout = LinearLayoutManager(this)
                binding.rvIncomplete.layoutManager = layout
                registrationFalse.add(itens)
                adapter = AdapterList(registrationFalse, this)
                binding.rvIncomplete.adapter = adapter
            }

        }

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java).apply {}
            startActivity(intent)
        }

    }
}