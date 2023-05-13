package com.yosuahaloho.retrokoran.domain.repository

import com.yosuahaloho.retrokoran.data.remote.response.HeadlineNewsResponse
import com.yosuahaloho.retrokoran.domain.model.Article
import com.yosuahaloho.retrokoran.util.Result
import com.yosuahaloho.retrokoran.util.UiState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

/**
 * Created by Yosua on 13/05/2023
 */
interface NewsRepository {

    suspend fun getHeadlineNews(country: String) : Flow<Result<List<Article>>>
}