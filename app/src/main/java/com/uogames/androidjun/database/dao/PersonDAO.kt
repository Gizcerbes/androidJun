package com.uogames.androidjun.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.uogames.androidjun.database.entity.PersonEntity

@Dao
interface PersonDAO {

	@Insert(onConflict = REPLACE)
	suspend fun save(personEntity: PersonEntity)


	@Query("SELECT * FROM persons WHERE `id`=:id")
	suspend fun getByID(id: Long): PersonEntity?

}