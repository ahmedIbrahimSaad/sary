package com.example.sarycatalog.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sarycatalog.datasource.BannerRepository
import com.example.sarycatalog.model.BannersResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BannerViewModel @Inject constructor(private val bannerRepository: BannerRepository) : ViewModel() {

    var banners = bannerRepository.bannersLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            bannerRepository.refreshBanners()
        }
    }

}