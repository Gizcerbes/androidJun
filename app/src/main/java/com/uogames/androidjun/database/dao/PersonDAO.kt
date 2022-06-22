package com.uogames.androidjun.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.uogames.androidjun.database.entity.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDAO {

    @Insert(onConflict = REPLACE)
    suspend fun save(personEntity: PersonEntity): Long

    @Delete
    suspend fun delete(personEntity: PersonEntity): Int

    @Query("SELECT * FROM persons WHERE `id`=:id")
    fun getByID(id: Long): Flow<PersonEntity?>

    @Query("SELECT * FROM persons")
    fun getAll(): Flow<List<PersonEntity>>

    @Query("SELECT id FROM persons")
    fun getAllId(): Flow<List<Long>>

}