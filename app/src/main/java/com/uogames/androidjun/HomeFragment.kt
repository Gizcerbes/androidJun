package com.uogames.androidjun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.uogames.androidjun.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

	private lateinit var bind : FragmentHomeBinding

	private lateinit var bottomSheet: BottomSheetBehavior<View>

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		bind = FragmentHomeBinding.inflate(inflater, container, false)
		return bind.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		bottomSheet =BottomSheetBehavior.from(bind.cardBehavior)
		bottomSheet.isFitToContents = false
		bottomSheet.halfExpandedRatio = 0.6f
	}


}