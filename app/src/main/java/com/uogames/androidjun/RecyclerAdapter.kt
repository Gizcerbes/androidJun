package com.uogames.androidjun

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.uogames.androidjun.database.dto.Person
import com.uogames.androidjun.databinding.CardPersonBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RecyclerAdapter(
    private val model: PersonViewModel
) :
    RecyclerView.Adapter<RecyclerAdapter.AbstractPersonHolder>() {

    private val recyclerScope = CoroutineScope(Dispatchers.Main)

    private var dataList = MutableStateFlow<List<Long>>(arrayListOf())

    init {
        model.getAllId().onEach {
            dataList.value = it
            notifyDataSetChanged()
        }.launchIn(recyclerScope)
    }

    abstract class AbstractPersonHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun show()
    }

    inner class PersonHolder(private val binding: CardPersonBinding) :
        AbstractPersonHolder(binding.root) {

        private var cardScope: CoroutineScope? = null

        override fun show() {
            cardScope?.cancel()
            cardScope = CoroutineScope(Dispatchers.Main)
            val position = adapterPosition
            if (position >= 0) {
                model.getPersonById(dataList.value[position]).onEach { person ->
                    person?.let {
                        binding.txtPersonId.text = person.id.toString()
                        binding.txtPersonName.text = person.personName
                        binding.remove.setOnClickListener {
                            model.delete(person) {

                            }
                        }
                        binding.root.setOnClickListener {
                            val dialog = ChangePersonDialog(person){
                                model.save(it){

                                }
                            }
                            dialog.show((itemView.context as AppCompatActivity).supportFragmentManager,ChangePersonDialog.TAG)
                        }
                    }
                }.launchIn(cardScope!!)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        // Here is you can change your holder Type
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractPersonHolder {
        return when (viewType) {
            0 -> PersonHolder(
                CardPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> PersonHolder(
                CardPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: AbstractPersonHolder, position: Int) {
        holder.show()
    }

    override fun getItemCount(): Int = dataList.value.size


}