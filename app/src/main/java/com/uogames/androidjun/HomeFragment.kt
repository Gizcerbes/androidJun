package com.uogames.androidjun

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.uogames.androidjun.database.dto.Person
import com.uogames.androidjun.databinding.FragmentHomeBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: PersonViewModel

    private lateinit var bind: FragmentHomeBinding

    private val adapter: RecyclerAdapter by lazy { RecyclerAdapter(viewModel) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentHomeBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bind.rvRecycler.adapter = adapter

        bind.button.setOnClickListener {
            val dialogFragment = AddPersonDialog {
                viewModel.save(Person(0, it)){

                }
            }
            dialogFragment.show(requireActivity().supportFragmentManager, AddPersonDialog.TAG)
        }
    }

    override fun onStart() {
        super.onStart()

        lifecycleScope.launch{
            viewModel.getAllPersons().first()
            adapter.notifyDataSetChanged()
        }
    }


}