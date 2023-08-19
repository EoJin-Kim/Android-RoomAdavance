package com.ej.roomadavance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ej.roomadavance.db.entity.NumberEntity
import com.ej.roomadavance.view.CustomAdapter
import com.ej.roomadavance.view.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()

    lateinit var numberArrayList: ArrayList<NumberEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createBtn = findViewById<Button>(R.id.create)
        createBtn.setOnClickListener {
            val ranNumber = (0..100).random().toString()
            val numberEntity = NumberEntity(0,ranNumber)

            viewModel.create(numberEntity)
        }

        val numberRx = findViewById<RecyclerView>(R.id.numberRV)

        viewModel.read()
        viewModel.numberEntityList.observe(this){
            numberArrayList = it as ArrayList<NumberEntity>

            val customAdapter = CustomAdapter(numberArrayList)

            numberRx.adapter = customAdapter

            onClickEventHandling(customAdapter)
        }

        numberRx.layoutManager = LinearLayoutManager(this)
    }

    private fun onClickEventHandling(customAdapter: CustomAdapter) {
        customAdapter.updateClick = object : CustomAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                viewModel.update(numberArrayList[position])
            }
        }

        customAdapter.deleteClick = object : CustomAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(this@MainActivity, numberArrayList[position].toString(), Toast.LENGTH_SHORT).show()
                viewModel.delete(numberArrayList[position])
            }
        }
    }
}