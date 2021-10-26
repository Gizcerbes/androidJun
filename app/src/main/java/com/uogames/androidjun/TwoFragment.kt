package com.uogames.androidjun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.uogames.androidjun.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

	private lateinit var bind: FragmentTwoBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		bind = FragmentTwoBinding.inflate(inflater, container, false)
		return bind.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		bind.bottomNavigation.setOnItemSelectedListener {
			bind.bottomNavFragment.findNavController().navigate(it.itemId)
//			when (it.itemId) {
//				R.id.fragment_home -> bind.bottomNavFragment.findNavController()
//					.navigate(R.id.fragment_home)
//				R.id.fragment_person -> bind.bottomNavFragment.findNavController()
//					.navigate(R.id.fragment_person)
//			}
			true
		}
	}


}