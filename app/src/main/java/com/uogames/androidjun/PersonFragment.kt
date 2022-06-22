package com.uogames.androidjun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uogames.androidjun.databinding.FragmentPersonBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PersonFragment : DaggerFragment() {


	@Inject
	lateinit var viewModel: PersonViewModel

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



	}

}