package com.yosuahaloho.retrokoran.data.remote

import com.yosuahaloho.retrokoran.data.remote.response.HeadlineNewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Yosua on 13/05/2023
 */
interface ApiService {

    @GET("top-headlines")
    suspend fun getHeadlineNews(
        @Query("country") country: String
    ): Response<HeadlineNewsResponse>
}