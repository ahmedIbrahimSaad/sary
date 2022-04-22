package com.example.sarycatalog.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sarycatalog.model.BannersResponse
import com.example.sarycatalog.model.CatalogResponse
import com.example.sarycatalog.network.BannersService
import com.example.sarycatalog.network.CatalogService
import javax.inject.Inject

class CatalogRepository @Inject constructor(
    private val catalogService: CatalogService
) {
    private val  catalogsLiveData = MutableLiveData<CatalogResponse>()

    fun getCatalogs(): LiveData<CatalogResponse> {
        return catalogsLiveData
    }

    suspend fun refreshCatalogs() {
        val catalogs: CatalogResponse
        try {
            catalogs = catalogService.getCatalog()
            catalogsLiveData.value = catalogs
        } catch (e: Exception) {
        }

    }
}