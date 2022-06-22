package com.uogames.androidjun

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uogames.androidjun.database.DatabaseRepository
import com.uogames.androidjun.database.dto.Person
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class PersonViewModel @Inject constructor(private val repository: DatabaseRepository) : ViewModel() {

	fun getPersonById(id:Long) = repository.getById(id)

	fun getAllPersons() = repository.getAll()

	fun getAllId() = repository.getAllId()

	fun save(person: Person,call: (Int) -> Unit){
		viewModelScope.launch {
			val result = repository.savePerson(person)
			call(getAllPersons().first().size -1)
		}
	}

	fun delete(person: Person, call: (Boolean) -> Unit){
		viewModelScope.launch {
			call(repository.deletePerson(person) > 0)
		}
	}

}