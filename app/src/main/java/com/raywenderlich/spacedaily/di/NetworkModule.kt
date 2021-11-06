package com.raywenderlich.spacedaily.di

import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
  single(named("BASE_URL")){ "https://api.nasa.gov/plantary/"}
}