package com.example.sarycatalog

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Device-Type", "android")
                .addHeader("App-Version", "5.5.0.0.0")
                .addHeader("Accept-Language", "ar")
                .addHeader("Platform", "FLAGSHIP")
                .addHeader("Authorization", "token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MjgxNTEyLCJ1c2VyX3Bob25lIjoiOTY2NTkxMTIyMzM0In0.phRQP0e5yQrCVfZiN4YlkI8NhXRyqa1fGRx5rvrEv0o")
                .build()
        )
    }
}