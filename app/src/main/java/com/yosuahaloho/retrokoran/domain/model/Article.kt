package com.yosuahaloho.retrokoran.domain.model

/**
 * Created by Yosua on 13/05/2023
 */
data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)