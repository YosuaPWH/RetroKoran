package com.yosuahaloho.retrokoran.data.repository

import com.yosuahaloho.retrokoran.data.remote.ApiService
import com.yosuahaloho.retrokoran.domain.model.Article
import com.yosuahaloho.retrokoran.domain.repository.NewsRepository
import com.yosuahaloho.retrokoran.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Yosua on 13/05/2023
 */
class NewsRepositoryImpl(private val apiService: ApiService) : NewsRepository {

    override suspend fun getHeadlineNews(country: String): Flow<Result<List<Article>>> = flow {
        try {
            apiService.getHeadlineNews(country).let { response ->
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        val data = body.articles.map { article ->
                            val titleSplit = article.title.split("-")
                            val newTitle = titleSplit.first().trim()
                            article.copy(title = newTitle)
                        }
                        val nonNullContent = data.filter { it.content != null }
                        emit(Result.Success(nonNullContent))
                    } else {
                        emit(Result.Failure("Response body is null"))
                    }
                } else {
                    emit(Result.Failure("Response error: ${response.errorBody()}"))
                }
            }
        } catch (e: Exception) {
            emit(Result.Failure(e.message.toString()))
        }
    }
}