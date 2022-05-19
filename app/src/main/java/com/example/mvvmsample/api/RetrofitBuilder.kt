package com.example.mvvmsample.api


import com.example.mvvmsample.utils.NetworkUtils
import com.example.mvvmsample.MyApplication
import com.example.mvvmsample.utils.AuthInterceptor
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit


/**
 *Created by tarikul on 5/9/20
 */
object RetrofitBuilder {
    // private const val BASE_URL = "https://catalog.chaldal.com/"
    // private const val BASE_URL = "https://howtodoandroid.com/"
    // private const val BASE_URL = "https://reqres.in/"
    private const val BASE_URL = "http://restapi.adequateshop.com/api/"

    // Caching data from online
    var cacheSize: Long = 5 * 1024 * 1024;
    var HEADER_CACHE_CONTROL: String = "Cache-Control"
    var HEADER_PRAGMA: String = "Pragma"


    var httpClient =
        OkHttpClient.Builder()
            .cache(cache())
            .addInterceptor(httpLoggingInterceptor())
            .addNetworkInterceptor(NetworkInterceptor())
            .addInterceptor(OfflineInterceptor())
            .addInterceptor(AuthInterceptor(MyApplication.instance.applicationContext))


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

    private fun cache(): Cache {
        return Cache(MyApplication.instance.cacheDir, cacheSize)
    }


    private fun httpLoggingInterceptor(): HttpLoggingInterceptor { // will call in the offline mode
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }


    class NetworkInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val response = chain.proceed(chain.request())
            val cacheControl = CacheControl.Builder()
                .maxAge(5, TimeUnit.SECONDS)
                .build()
            return response.newBuilder()
                .removeHeader(HEADER_PRAGMA)
                .removeHeader(HEADER_CACHE_CONTROL)
                .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                .build()
        }
    }

    class OfflineInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()

            if (!NetworkUtils.hasNetwork(MyApplication.instance.applicationContext)!!) {
                val cacheControl: CacheControl = CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS).build()
                request.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .cacheControl(cacheControl)
                    .build();
            }
            return chain.proceed(request)
        }
    }

}