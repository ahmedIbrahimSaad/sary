package com.example.sarycatalog

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.sarycatalog.model.BannersResponse
import com.example.sarycatalog.model.CatalogResponse
import com.example.sarycatalog.presentation.ImageAdapter
import com.example.sarycatalog.presentation.ItemsAdapter
import com.example.sarycatalog.presentation.MenusAdapter
import com.example.sarycatalog.viewModel.BannerViewModel
import com.example.sarycatalog.viewModel.CatalogViewModel
import com.google.android.material.imageview.ShapeableImageView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {


    val viewModel : BannerViewModel by viewModels()
    private val catalogViewModel:CatalogViewModel by viewModels()
    private val menuRecycler: RecyclerView by lazy { findViewById( com.example.sarycatalog.R.id.menuRecycler) }
    private val generalLinearLayout: LinearLayout by lazy { findViewById(com.example.sarycatalog.R.id.generalLinearLayout) }
    private val banner : ShapeableImageView by lazy { findViewById(com.example.sarycatalog.R.id.banner) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val actionBar: ActionBar? = supportActionBar
        actionBar!!.hide()
        viewModel.banners.observe(this) { observeResponse(it) }
        catalogViewModel.catalogs .observe(this){observeMenus(it)}

    }
    private fun observeMenus(it: CatalogResponse?) {
        val menusAdapter= MenusAdapter()
        menusAdapter.setMenuList(it!!.result[0].data)
        menuRecycler.adapter=menusAdapter
       val temp= it.result.subList(1,it.result.size)
        for(a in temp){

            if(!a.title.isNullOrBlank()&& a.uiType in listOf("grid","linear","grid") && a.data.isNotEmpty()){
                val title= TextView(this)
                title.text=a.title
                generalLinearLayout.addView(title)
            }
            if(a.data.isNotEmpty()){

                when (a.uiType) {
                    "grid" -> {
                        if(a.data.isNotEmpty()){
                            val itemsAdapter=ItemsAdapter()
                            val rv = RecyclerView(this)
                            val params = RecyclerView.LayoutParams(
                                RecyclerView.LayoutParams.MATCH_PARENT,
                                RecyclerView.LayoutParams.WRAP_CONTENT
                            )
                            rv.layoutParams = params

                            val llm= GridLayoutManager(this,4)
                            rv.layoutManager =llm

                            itemsAdapter.setMenuList(a.data)
                            rv.adapter = itemsAdapter

                            generalLinearLayout.addView(rv)
                            val v = View(this)
                            v.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                5
                            )
                            v.setBackgroundColor(Color.parseColor("#B3B3B3"))

                            generalLinearLayout.addView(v)
                        }

                    }
                    "linear" -> {
                        if(a.data.isNotEmpty()){
                            val itemsAdapter=MenusAdapter()

                            val rv = RecyclerView(this)
                            val params = RecyclerView.LayoutParams(
                                RecyclerView.LayoutParams.MATCH_PARENT,
                                RecyclerView.LayoutParams.WRAP_CONTENT
                            )
                            rv.layoutParams = params
                            val llm= LinearLayoutManager(this)
                            llm.orientation= LinearLayoutManager.HORIZONTAL
                            rv.layoutManager =llm
                            itemsAdapter.setMenuList(a.data )
                            rv.adapter = itemsAdapter

                            generalLinearLayout.addView(rv)
                            val v = View(this)
                            v.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                5
                            )
                            v.setBackgroundColor(Color.parseColor("#B3B3B3"))

                            generalLinearLayout.addView(v)

                        }

                    }
                    "slider" -> {
                        val images:MutableList<String> = ArrayList()
                        for(x in a.data)
                            if(!x.image.isNullOrBlank()){
                                images.add(x.image)
                            }
                        if(images.isNotEmpty()){
                            val imageAdapter=ImageAdapter()

                            val mViewPager =  ViewPager(this)
                            val params = RecyclerView.LayoutParams(
                                RecyclerView.LayoutParams.WRAP_CONTENT,
                                180
                            )
                            mViewPager.layoutParams = params
                            imageAdapter.setImageList(images)
                            mViewPager.adapter = imageAdapter
                            generalLinearLayout.addView(mViewPager)

                            val v = View(this)
                            v.layoutParams = LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                5
                            )
                            v.setBackgroundColor(Color.parseColor("#B3B3B3"))

                            generalLinearLayout.addView(v)

                        }

                    }
                }

            }

        }
    }

    private fun observeResponse(it: BannersResponse?) {
        if(it!!.result!=null)
            Glide.with(this)
                .load(Uri.parse(it.result!![0]!!.photo!!))
                .into(banner)
    }
}


