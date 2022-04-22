package com.example.sarycatalog.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sarycatalog.model.BannersResponse
import com.example.sarycatalog.network.BannersService
import javax.inject.Inject

class BannerRepository @Inject constructor(
    private val bannersService: BannersService
) {
  private val  bannersLiveData =MutableLiveData<BannersResponse>()
    fun getBanners(): LiveData<BannersResponse> {
        return bannersLiveData
    }

    suspend fun refreshBanners() {
        val banners: BannersResponse
        try {
            banners = bannersService.getBanners()
            bannersLiveData.value = banners
        } catch (e: Exception) {
        }

    }

}