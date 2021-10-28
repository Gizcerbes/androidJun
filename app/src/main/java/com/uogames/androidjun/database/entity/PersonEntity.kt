package com.uogames.androidjun.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class PersonEntity(
	@PrimaryKey(autoGenerate = true)
	val id: Long,
	val personName: String
)
