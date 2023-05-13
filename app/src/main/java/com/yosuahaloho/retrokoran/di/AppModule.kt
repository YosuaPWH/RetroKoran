package com.yosuahaloho.retrokoran.di

import com.yosuahaloho.retrokoran.BuildConfig
import com.yosuahaloho.retrokoran.data.remote.ApiService
import com.yosuahaloho.retrokoran.data.repository.NewsRepositoryImpl
import com.yosuahaloho.retrokoran.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Yosua on 13/05/2023
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor {
                val ori = it.request()
                val urlWithApiKey = ori.url
                    .newBuilder()
                    .addQueryParameter("apiKey", BuildConfig.API_KEY)
                    .build()

                val request = ori
                    .newBuilder()
                    .url(urlWithApiKey)
                    .build()

                it.proceed(request)
            }.build()

    @Provides
    @Singleton
    fun provideApiAuthInstance(okHttpClient: OkHttpClient): ApiService =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(api: ApiService) : NewsRepository {
        return NewsRepositoryImpl(api)
    }

}