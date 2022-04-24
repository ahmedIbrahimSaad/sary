package com.example.sarycatalog.presentation

import android.R
import android.content.Context
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import javax.inject.Inject


class ImageAdapter : PagerAdapter() {
     private lateinit var sliderImageId :List<String>

    fun setImageList(sliderImageList :List<String>){
        sliderImageId=sliderImageList
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ImageView
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(container.context)
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
        Glide.with(container.context)
            .load(Uri.parse(sliderImageId[position]))
            .into(imageView)
        (container as ViewPager).addView(imageView, 0)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as ImageView)
    }

    override fun getCount(): Int {
        return sliderImageId.size
    }

}