package com.example.sarycatalog.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sarycatalog.datasource.CatalogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel  @Inject constructor(private val catalogRepository: CatalogRepository) : ViewModel() {
    var catalogs = catalogRepository.catalogsLiveData
    init {
        viewModelScope.launch(Dispatchers.IO) {
            catalogRepository.refreshCatalogs()
        }
    }
}