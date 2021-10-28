package com.uogames.androidjun

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uogames.androidjun.databinding.FragmentHomeBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

	@Inject
	lateinit var viewModel: MyViewModel

	private lateinit var bind : FragmentHomeBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		bind = FragmentHomeBinding.inflate(inflater, container, false)
		return bind.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		bind.button.setOnClickListener {
			viewModel.saveMyPerson(bind.textField.editText?.text.toString())
			bind.textField.editText?.setText("")
		}
	}


}