package com.example.sarycatalog.datasource

import androidx.lifecycle.MutableLiveData
import com.example.sarycatalog.model.CatalogResponse
import com.example.sarycatalog.network.CatalogService
import javax.inject.Inject

class CatalogRepository @Inject constructor(
    private val catalogService: CatalogService
) {
     val  catalogsLiveData = MutableLiveData<CatalogResponse>()


    suspend fun refreshCatalogs() {
        val catalogs: CatalogResponse
        try {
            catalogs = catalogService.getCatalog()
            catalogsLiveData.postValue(catalogs)
        } catch (e: Exception) {
        }

    }
}