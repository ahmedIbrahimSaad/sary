package com.example.sarycatalog.presentation

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarycatalog.R
import com.example.sarycatalog.model.DataItem
import javax.inject.Inject

class ItemsAdapter  :RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>(){
    class ItemsViewHolder (v: View):RecyclerView.ViewHolder(v){
        private val imageView: ImageView by lazy { v.findViewById(R.id.itemImageView) }
        // private val title:TextView by lazy { view.findViewById(R.id.title) }
        fun bind( dataItem: DataItem){
//            if(!dataItem.name.isNullOrBlank())
//            title.text=dataItem.name
            if(!dataItem.image.isNullOrBlank())
                Glide.with(itemView)
                    .load(Uri.parse(dataItem.image))
                    .into(imageView)
        }
    }

    private  lateinit var menuList :List<DataItem>

    fun setMenuList( list :List<DataItem>){
        menuList =list
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(menuList[position])
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, menuList[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }


}