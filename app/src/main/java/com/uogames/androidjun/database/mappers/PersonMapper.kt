package com.uogames.androidjun.database.mappers

import com.uogames.androidjun.database.dto.Person
import com.uogames.androidjun.database.entity.PersonEntity

object PersonMapper : Mapper<PersonEntity, Person> {
	override fun toDTO(from: PersonEntity): Person {
		return Person(
			id = from.id,
			personName = from.personName
		)
	}

	override fun toEntity(from: Person): PersonEntity {
		return PersonEntity(
			id = from.id,
			personName = from.personName
		)
	}
}