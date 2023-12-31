package com.ej.roomadavance.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ej.roomadavance.R
import com.ej.roomadavance.db.entity.NumberEntity

class CustomAdapter(private val dataSet :ArrayList<NumberEntity>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    interface  ItemClick {
        fun onClick(view : View, position: Int)
    }

    var updateClick  :ItemClick? = null
    var deleteClick  :ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.number_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idArea.text = dataSet[position].id.toString()
        holder.randomNum.text = dataSet[position].randomNumber.toString()

        holder.itemView.findViewById<Button>(R.id.update).setOnClickListener { v->
            updateClick?.onClick(v, position)
        }

        holder.itemView.findViewById<Button>(R.id.delete).setOnClickListener { v->
            deleteClick?.onClick(v, position)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(private val view : View):RecyclerView.ViewHolder(view){
        val idArea : TextView
        val randomNum : TextView

        init {
            idArea = view.findViewById(R.id.id)
            randomNum = view.findViewById(R.id.randomNum)
        }

    }

}