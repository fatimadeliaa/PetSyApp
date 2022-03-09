package com.adelianainggolan.petadoptionapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import com.adelianainggolan.petadoptionapp.R
import com.adelianainggolan.petadoptionapp.utils.setImage
import java.util.*

class ImageSliderAdapter(
    var context: Context,
    var images: IntArray
) : PagerAdapter() {

    private var layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        // return the number of images
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // inflating the item.xml
        val itemView = layoutInflater.inflate(R.layout.item_slider, container, false)

        // referencing the image view from the item.xml file
        val imageView = itemView.findViewById<View>(R.id.iv_home_slider) as ImageView

        // setting the image in the imageView
        imageView.setImage(context, images[position])

        // Adding the View
        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}