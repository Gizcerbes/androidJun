package com.uogames.androidjun

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uogames.androidjun.databinding.FragmentPersonBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PersonFragment : DaggerFragment() {


	@Inject
	lateinit var viewModel: MyViewModel

	private lateinit var bind: FragmentPersonBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		bind = FragmentPersonBinding.inflate(inflater, container, false)
		return bind.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		bind.button.setOnClickListener {
			viewModel.getPersonById(bind.textField.editText?.text.toString().toDefaultLong(0)) {
				bind.personText.text = it.toString()
			}
		}
	}

	private fun String.toDefaultLong(long: Long): Long {
		return try {
			this.toLong()
		} catch (e: Exception) {
			long
		}
	}


}