package com.example.latihanfirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rvAdapater(private val userList : ArrayList<User>) : RecyclerView.Adapter<rvAdapater.rvHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_card,
        parent,false)
        return rvHolder(itemView)
    }

    override fun onBindViewHolder(holder: rvHolder, position: Int) {

        val currentitem = userList[position]

        holder.nama.text = currentitem.nama
        holder.umur.text = currentitem.umur

    }

    override fun getItemCount(): Int {

        return userList.size
    }

    class rvHolder (ItemView : View) : RecyclerView.ViewHolder(ItemView){

        val nama : TextView = itemView.findViewById(R.id.tvnama)
        val umur : TextView = itemView.findViewById(R.id.tvumur)
    }



}