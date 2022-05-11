package com.example.sarycatalog.module

import com.example.sarycatalog.BuildConfig
import com.example.sarycatalog.network.BannersService
import com.example.sarycatalog.network.CatalogService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
const val BASEURL="https://staging.sary.to/"
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASEURL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideBannerService(retrofit: Retrofit): BannersService =
        retrofit.create(BannersService::class.java)

    @Provides
    @Singleton
    fun provideCatalogService(retrofit: Retrofit): CatalogService =
        retrofit.create(CatalogService::class.java)

}