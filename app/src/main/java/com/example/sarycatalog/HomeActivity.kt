package com.example.sarycatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.example.sarycatalog.viewModel.BannerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
   val viewModel : BannerViewModel by viewModels()
   private val button :Button by lazy { findViewById(R.id.button) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel.banners
        button.setOnClickListener { startActivity(Intent(this,CatalogActivity::class.java)) }
    }
}