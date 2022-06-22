package com.uogames.androidjun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.uogames.androidjun.database.dto.Person
import com.uogames.androidjun.databinding.FragmentAddPersonBinding

class ChangePersonDialog(val person: Person,val call: (Person) -> Unit) : DialogFragment() {


    companion object {
        const val TAG = "CHANGE_PERSON_DIALOG"
    }

    private lateinit var binding: FragmentAddPersonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tilSearch.editText?.setText(person.personName)

        binding.btnAdd.setOnClickListener {
            binding.tilSearch.editText?.text?.let {
                if(it.isNotEmpty()) call(Person(person.id, it.toString()))
                dismiss()
            }
        }

        binding.btnClose.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            setLayout(width, height)
        }
    }


}