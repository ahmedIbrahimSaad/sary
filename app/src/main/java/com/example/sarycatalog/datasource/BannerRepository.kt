package com.example.sarycatalog.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sarycatalog.model.BannersResponse
import com.example.sarycatalog.network.BannersService
import javax.inject.Inject

class BannerRepository @Inject constructor(
    private val bannersService: BannersService
) {
   val  bannersLiveData =MutableLiveData<BannersResponse>()
    suspend fun refreshBanners() {
        val banners: BannersResponse
        try {
            banners = bannersService.getBanners()
            bannersLiveData.postValue(banners)
        } catch (e: Exception) {
        }

    }

}