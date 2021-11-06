package com.raywenderlich.spacedaily.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.util.concurrent.TimeUnit.SECONDS

val networkModule = module {
  single(named("BASE_URL")) { "https://api.nasa.gov/plantary/" }
  single {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    interceptor
  }
  single {
    val client = OkHttpClient().newBuilder()
      .connectTimeout(30, SECONDS)
      .writeTimeout(30, SECONDS)
      .readTimeout(30, SECONDS)
    if (BuildConfig.DEBUG)
      client.addInterceptor(get<HttpLoggingInterceptor>())
    client.build()
  }
  single {
    Moshi.Builder()
      .add(KotlinJsonAdapterFactory()).build()

  }
}