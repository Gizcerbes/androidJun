package com.uogames.androidjun.database.mappers

interface Mapper<T, R> {

	fun toDTO(from: T): R

	fun toEntity(from: R): T

}