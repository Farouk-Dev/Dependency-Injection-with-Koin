package com.raywenderlich.spacedaily

import com.raywenderlich.spacedaily.di.networkModule
import com.raywenderlich.spacedaily.network.NasaApiInterface
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import retrofit2.Retrofit

class NetworkTest : KoinTest {
  private val baseUrl: String by lazy { get(named("BASE_URL")) as String }
  private val interceptor: HttpLoggingInterceptor by inject()
  private val httpClient: OkHttpClient by inject()
  private val moshi: Moshi by inject()
  private val retrofit: Retrofit by inject()
  private val apiService: NasaApiInterface by inject()

  @Before
  fun setup() {
    startKoin {
      modules(listOf(networkModule))
    }
  }

  @After
  fun tearDown() {
    stopKoin()
  }

  @Test
  fun `test base url created`() {
    assertEquals(baseUrl, "https://api.nasa.gov/planetary/")
  }

  @Test
  fun `test interceptor created`() {
    assertNotNull(interceptor)
  }

  @Test
  fun `test httpClient created`() {
    assertNotNull(httpClient)
    assertTrue(httpClient.connectTimeoutMillis==30000)
    assertTrue(httpClient.readTimeoutMillis==30000)
    assertTrue(httpClient.writeTimeoutMillis==30000)
    assertTrue(httpClient.interceptors.size==1)
  }

  @Test
  fun `test moshi created`() {
    assertNotNull(moshi)
  }

  @Test
  fun `test retrofit created`() {
    assertNotNull(retrofit)
  }

  @Test
  fun `test apiService created`() {
    assertNotNull(apiService)
  }
}