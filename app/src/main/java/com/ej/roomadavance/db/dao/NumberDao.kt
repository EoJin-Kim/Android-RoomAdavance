package com.ej.roomadavance.db.dao

import androidx.room.*
import com.ej.roomadavance.db.entity.NumberEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun create(numberEntity: NumberEntity)

    @Query("SELECT * FROM number_table")
    fun read() : Flow<List<NumberEntity>>

    @Update
    fun update(numberEntity: NumberEntity)

    @Delete
    fun delete(numberEntity: NumberEntity)
}