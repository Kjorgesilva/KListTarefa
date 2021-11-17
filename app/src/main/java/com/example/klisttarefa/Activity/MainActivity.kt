package com.example.klisttarefa.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klisttarefa.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd: FloatingActionButton
    private lateinit var recyclerViewIncomplete: RecyclerView
    private lateinit var recyclerViewCompleted: RecyclerView
    private lateinit var registration: ArrayList<Registration>
    private lateinit var registrationTrue: ArrayList<Registration>
    private lateinit var registrationFalse: ArrayList<Registration>
    private lateinit var adapter: RecyclerView.Adapter<AdapterList.ItemViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findById()
        onClickView()

        registration = ArrayList()
        registrationTrue = ArrayList()
        registrationFalse = ArrayList()
        val registrationOne = Registration("Go to the gym", "Sport", true)
        val registrationTwo = Registration("Go to school", "study", false)



        registration.add(registrationOne)
        registration.add(registrationTwo)


        for (itens in registration) {
            if (itens.check == true) {
                val layout = LinearLayoutManager(this)
                recyclerViewCompleted.layoutManager = layout
                registrationTrue.add(itens)
                adapter = AdapterList(registrationTrue, this)
                recyclerViewCompleted.adapter = adapter
            } else{
                val layout = LinearLayoutManager(this)
                recyclerViewIncomplete.layoutManager = layout
                registrationFalse.add(itens)
                adapter = AdapterList(registrationFalse, this)
                recyclerViewIncomplete.adapter = adapter
            }

        }

    }


    fun findById() {
        btnAdd = findViewById(R.id.floatingActionButton)
        recyclerViewCompleted = findViewById(R.id.rv_Completed)
        recyclerViewIncomplete = findViewById(R.id.rv_Incomplete)
    }

    fun onClickView() {
        btnAdd.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java).apply {}
            startActivity(intent)
        }
    }
}