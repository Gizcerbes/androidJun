package com.uogames.androidjun

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.uogames.androidjun.database.DatabaseRepository
import com.uogames.androidjun.database.dto.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor(private val repository: DatabaseRepository) : ViewModel() {

	private val ioScope = CoroutineScope(Dispatchers.IO)
	private val mainScope = CoroutineScope(Dispatchers.Main)


	fun saveMyPerson(personName: String) {
		ioScope.launch {
			repository.savePerson(Person(0, personName))
		}
	}

	fun getPersonById(id:Long, callback: (Person) -> Unit){
		ioScope.launch {
			repository.getById(id)?.let {
				mainScope.launch { callback(it) }
			}
		}
	}

}