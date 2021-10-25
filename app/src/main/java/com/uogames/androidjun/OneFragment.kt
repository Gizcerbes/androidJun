package com.uogames.androidjun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.uogames.androidjun.databinding.FragmentOneBinding

class OneFragment: Fragment() {

	private lateinit var bind: FragmentOneBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		bind = FragmentOneBinding.inflate(inflater, container, false)
		return bind.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		bind.button.setOnClickListener {
			findNavController().navigate(R.id.to_twoFragment)
		}
	}


}