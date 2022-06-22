package com.uogames.androidjun.database.mappers

import com.uogames.androidjun.database.dto.Person
import com.uogames.androidjun.database.entity.PersonEntity

object PersonMapper : Mapper<PersonEntity, Person> {
	override fun PersonEntity.toDTO(): Person {
		return Person(
			id = id,
			personName = personName
		)
	}

	override fun Person.toEntity(): PersonEntity {
		return PersonEntity(
			id = id,
			personName = personName
		)
	}

}