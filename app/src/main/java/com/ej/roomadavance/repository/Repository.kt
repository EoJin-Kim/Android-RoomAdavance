package com.ej.roomadavance.repository

import com.ej.roomadavance.MyApp
import com.ej.roomadavance.db.MyDatabase
import com.ej.roomadavance.db.entity.NumberEntity

class Repository {

    private val context = MyApp.context()

    private val db = MyDatabase.getDatabase(context)

    fun create(numberEntity: NumberEntity) = db.numberDao().create(numberEntity)

    fun read() = db.numberDao().read()

    fun update(numberEntity: NumberEntity) = db.numberDao().update(numberEntity)

    fun delete(numberEntity: NumberEntity) = db.numberDao().delete(numberEntity)
}