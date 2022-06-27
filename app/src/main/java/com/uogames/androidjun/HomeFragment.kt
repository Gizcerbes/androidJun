package com.uogames.androidjun

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.uogames.androidjun.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var bind: FragmentHomeBinding

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
        bottomSheet = BottomSheetBehavior.from(bind.cardBehavior)
        bottomSheet.isFitToContents = false
        bottomSheet.halfExpandedRatio = 0.6f

        bind.hider.visibility = View.GONE


        bind.btn.setOnClickListener {
            Log.e("TAG", "btn: ", )
        }

        bottomSheet.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                bind.hider.visibility =
                    if (newState == BottomSheetBehavior.STATE_COLLAPSED) View.GONE else View.VISIBLE
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
        bind.cardBehavior.setOnClickListener {
            Log.e("TAG", "cardBehavior: ", )
        }

        bind.hider.setOnClickListener {
            bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }


    }

}