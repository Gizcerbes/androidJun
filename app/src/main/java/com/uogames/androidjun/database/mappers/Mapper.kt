package com.uogames.androidjun.database.mappers

interface Mapper<T, R> {

	fun T.toDTO(): R

	fun R.toEntity(): T

}