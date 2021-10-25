package com.uogames.androidjun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uogames.androidjun.databinding.FragmentPersonBinding

class PersonFragment : Fragment(){

	private lateinit var bind: FragmentPersonBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		bind = FragmentPersonBinding.inflate(inflater,container, false)
		return bind.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

	}


}