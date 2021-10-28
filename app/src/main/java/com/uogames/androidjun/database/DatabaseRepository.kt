package com.uogames.androidjun.database

import android.content.Context
import com.uogames.androidjun.database.dto.Person
import com.uogames.androidjun.database.mappers.PersonMapper

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
		database.personDAO().save(PersonMapper.toEntity(person))

	suspend fun getById(id: Long) = database.personDAO().getByID(id)?.let { PersonMapper.toDTO(it) }


}