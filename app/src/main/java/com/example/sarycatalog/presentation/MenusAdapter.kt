package com.example.sarycatalog.presentation

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarycatalog.R
import com.example.sarycatalog.model.DataItem
import com.example.sarycatalog.model.ResultItemCatalogResponse
import javax.inject.Inject

class MenusAdapter : RecyclerView.Adapter<MenusAdapter.MenusViewHolder>() {

    private  lateinit var menuList :List<DataItem>

    fun setMenuList(list: List<DataItem>){
        menuList =list
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenusViewHolder {
        return MenusViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.menu_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenusViewHolder, position: Int) {
        holder.bind(menuList[position])
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, menuList[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
       return menuList.size
    }

    inner class MenusViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val imageView:ImageView by lazy { view.findViewById(R.id.imageView) }
        private val title:TextView by lazy { view.findViewById(R.id.title) }
        fun bind( dataItem: DataItem){
            if(!dataItem.name.isNullOrBlank())
            title.text=dataItem.name

            Glide.with(itemView)
                .load(Uri.parse(dataItem.image?:"")).error(R.drawable.ic_launcher_foreground)
                .into(imageView)
        }
    }
    interface ClickListener{}
}