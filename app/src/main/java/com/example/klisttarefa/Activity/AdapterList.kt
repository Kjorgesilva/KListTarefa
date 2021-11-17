package com.example.klisttarefa.Activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.klisttarefa.R


class AdapterList(val listItem:ArrayList<Registration>, val context : Context): RecyclerView.Adapter<AdapterList.ItemViewHolder>(){

    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val checkBox = view.findViewById(R.id.checkBox) as CheckBox
        val activity = view.findViewById(R.id.tx_activity) as TextView
        val type = view.findViewById(R.id.tx_type) as TextView
    }


   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterList.ItemViewHolder {
       val viewLayoutInfla = LayoutInflater.from(parent.context).inflate(R.layout.adapter_list,parent,false)
       return ItemViewHolder(viewLayoutInfla)    }

    override fun onBindViewHolder(holder: AdapterList.ItemViewHolder, position: Int) {
        holder.checkBox.text = listItem[position].check.toString()
        holder.activity.text = listItem[position].activity
        holder.type.text = listItem[position].type

        for (item in listItem){
            if (item.check== true){
                holder.checkBox.isChecked = true
            }else{
                holder.checkBox.isChecked = false
            }
            holder.checkBox.text = ""

        }

    }

    override fun getItemCount(): Int = listItem.size

}


