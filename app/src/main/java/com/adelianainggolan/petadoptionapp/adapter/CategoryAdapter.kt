package com.adelianainggolan.petadoptionapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.model.CategoryPetModel
import com.adelianainggolan.petadoptionapp.utils.setImage
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_cat_pet.view.*

class CategoryAdapter(private  val listCategoryPetModel: ArrayList<CategoryPetModel>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    inner  class CategoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(categoryPetModel: CategoryPetModel) {
            with(itemView) {
                iv_pet_category.setImage(itemView.context, categoryPetModel.petIcon)
                tv_pet_category.text = categoryPetModel.petCategory
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat_pet, parent, false)
        return  CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(listCategoryPetModel[position])
    }

    override fun getItemCount(): Int  = listCategoryPetModel.size
}