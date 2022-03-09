package com.adelianainggolan.petadotionapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.model.PetModel
import com.adelianainggolan.petadoptionapp.utils.setImage
import kotlinx.android.synthetic.main.item_pet.view.*

class HomeAdapter(private val listener: (PetModel) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val modelHome = ArrayList<PetModel>()

    fun setData(items: ArrayList<PetModel>) {
        modelHome.clear()
        modelHome.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: PetModel, modelHome: (PetModel) -> Unit) {
            with(itemView) {
                iv_pet_item.setImage(itemView.context, model.petImage)
                tv_pet_name_item.setText(model.petName)
                tv_pet_sex_item.setText(model.petSex)
                tv_pet_distance_item.setText(model.petDistance)

                itemView.setOnClickListener { modelHome(model) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(modelHome[position], listener)
    }

    override fun getItemCount(): Int = modelHome.size

}