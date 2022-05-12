package com.example.sarycatalog.network

import com.example.sarycatalog.model.BannersResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface BannersService {
    @GET("/api/v2.5.1/baskets/325514/banners")
    suspend fun getBanners(): BannersResponse
}