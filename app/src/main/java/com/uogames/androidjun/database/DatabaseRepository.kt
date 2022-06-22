package com.uogames.androidjun.database

import android.content.Context
import com.uogames.androidjun.database.dto.Person
import com.uogames.androidjun.database.mappers.PersonMapper
import com.uogames.androidjun.database.mappers.PersonMapper.toDTO
import com.uogames.androidjun.database.mappers.PersonMapper.toEntity
import kotlinx.coroutines.flow.map

class DatabaseRepository private constructor(private val database: MyDatabase) {

	companion object {
		private var INSTANCE: DatabaseRepository? = null

		fun get(context: Context): DatabaseRepository {
			if (INSTANCE == null) {
				INSTANCE = DatabaseRepository(MyDatabase.get(context))
			}
			return INSTANCE as DatabaseRepository
		}
	}

	suspend fun savePerson(person: Person) =
		database.personDAO().save(person.toEntity())

	suspend fun deletePerson(person: Person) = database.personDAO().delete(person.toEntity())

	fun getById(id: Long) = database.personDAO().getByID(id).map { it?.toDTO() }

	fun getAll() = database.personDAO().getAll().map { it.map { person -> person.toDTO() } }

	fun getAllId() = database.personDAO().getAllId()

}