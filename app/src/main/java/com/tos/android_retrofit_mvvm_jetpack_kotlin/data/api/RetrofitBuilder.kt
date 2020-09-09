package com.tos.myapplication.data.api


import com.tos.android_retrofit_mvvm_jetpack_kotlin.MyApplication
import okhttp3.Cache
import okhttp3.Interceptor.Companion.invoke
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *Created by tarikul on 5/9/20
 */
object RetrofitBuilder {
    private const val BASE_URL = "https://catalog.chaldal.com/"

    // Caching data from online
    var cacheSize: Long = 5 * 1024 * 1024;
    var HEADER_CACHE_CONTROL: String = "Cache-Control"
    var HEADER_PRAGMA: String = "Pragma"


    var httpClient: OkHttpClient.Builder =
        OkHttpClient.Builder()
            .cache(cache())
            .addInterceptor(httpLoggingInterceptor())


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


    /*private fun networkInterceptor(): Interceptor {

    }*/
    /*
    *
 private static Interceptor offlineInterceptor() {
        return chain -> {
            Log.d(TAG, "offline interceptor: called.");
            Request request = chain.request();

            // prevent caching when network is on. For that we use the "networkInterceptor"
            if (!MyApplication.hasNetwork()) {
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build();

                request = request.newBuilder()
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .cacheControl(cacheControl)
                        .build();
            }

            return chain.proceed(request);
        };
    }
    *
    *
    private static Interceptor networkInterceptor() {
        return chain -> {
            Log.d(TAG, "network interceptor: called.");

            Response response = chain.proceed(chain.request());

            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(5, TimeUnit.SECONDS)
                    .build();

            return response.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                    .build();
        };

    }*/
}