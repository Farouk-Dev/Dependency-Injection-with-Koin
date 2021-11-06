package com.raywenderlich.spacedaily.di

import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
  single(named("BASE_URL")){ "https://api.nasa.gov/plantary/"}
  single {
    val interceptor=HttpLoggingInterceptor()
    interceptor.level=HttpLoggingInterceptor.Level.BODY
    interceptor
  }
}