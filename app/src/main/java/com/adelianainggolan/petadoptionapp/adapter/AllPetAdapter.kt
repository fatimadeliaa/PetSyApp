package com.adelianainggolan.petadoptionapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.model.PetModel
import kotlinx.android.synthetic.main.item_staggered.view.*

class AllPetAdapter(private val listStaggered : ArrayList<PetModel>) : RecyclerView.Adapter<AllPetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staggered, parent, false)
        return ViewHolder(view )
    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStaggered[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: PetModel) {
            with(itemView){
                iv_pet_staggered.setImageResource(model.petImage)
                tv_pet_name_staggered.setText(model.petName)
                tv_pet_sex_staggered.setText(model.petSex)
                tv_pet_distance_staggered.setText(model.petDistance)
            }
        }

    }
}