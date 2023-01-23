package com.skycore.practicaltest.koin

import com.skycore.practicaltest.BuildConfig
import com.skycore.practicaltest.repository.MainRepository
import com.skycore.practicaltest.retrofit.RetrofitService
import com.skycore.practicaltest.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideForecastApi(get()) }
    single { provideRetrofit() }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideForecastApi(retrofit: Retrofit): RetrofitService = retrofit.create(RetrofitService::class.java)

val mymodule = module{

    single { MainRepository(get()) }
    viewModel { MainViewModel(get()) }
}