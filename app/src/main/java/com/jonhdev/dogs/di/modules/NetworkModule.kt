package com.jonhdev.dogs.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {

    @Provides
    @JvmStatic
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            readTimeout(5, TimeUnit.SECONDS)
            connectTimeout(5, TimeUnit.SECONDS)
        }.build()
    }

    @Provides
    @JvmStatic
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @JvmStatic
    fun providesRetrofitClient(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

}