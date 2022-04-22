package com.example.sarycatalog.network

import com.example.sarycatalog.model.BannersResponse
import com.example.sarycatalog.model.CatalogResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface CatalogService {
    @Headers(
        "Device-Type: android",
        "App-Version: 5.5.0.0.0",
        "Accept-Language: ar",
        "Platform: FLAGSHIP",
        "Authorization: token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MjgxNTEyLCJ1c2VyX3Bob25lIjoiOTY2NTkxMTIyMzM0In0.phRQP0e5yQrCVfZiN4YlkI8NhXRyqa1fGRx5rvrEv0o"
    )
    @GET("/api/baskets/325514/catalog")
    suspend fun getCatalog(): CatalogResponse
}