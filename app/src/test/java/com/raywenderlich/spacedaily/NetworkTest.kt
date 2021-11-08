package com.raywenderlich.spacedaily

import com.raywenderlich.spacedaily.di.networkModule
import com.raywenderlich.spacedaily.network.NasaApiInterface
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import retrofit2.Retrofit

class NetworkTest:KoinTest {
  val baseUrl :String by lazy { get(named("BASE_URL")) as String}
  val interceptor :HttpLoggingInterceptor by inject()
  val httpClient: OkHttpClient by inject()
  val moshi: Moshi by inject()
  val retrofit:Retrofit by inject()
  val apiService:NasaApiInterface by inject()

  @Before
  fun setup(){
    startKoin {
      modules(listOf(networkModule))
    }
  }

  @After
  fun tearDown(){
    stopKoin()
  }

}