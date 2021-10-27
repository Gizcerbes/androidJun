package com.uogames.androidjun

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MyViewModel @Inject constructor(private val context: Context) : ViewModel() {


	fun showToast(string: String) {
		Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
	}


}