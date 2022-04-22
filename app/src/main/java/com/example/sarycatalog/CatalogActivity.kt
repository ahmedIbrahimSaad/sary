package com.example.sarycatalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.sarycatalog.viewModel.CatalogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogActivity : AppCompatActivity() {
    val viewModel : CatalogViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        viewModel.catalogs
    }
}