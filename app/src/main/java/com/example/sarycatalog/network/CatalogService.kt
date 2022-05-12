package com.example.sarycatalog.network

import com.example.sarycatalog.model.CatalogResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface CatalogService {
    @GET("/api/baskets/325514/catalog")
    suspend fun getCatalog(): CatalogResponse
}