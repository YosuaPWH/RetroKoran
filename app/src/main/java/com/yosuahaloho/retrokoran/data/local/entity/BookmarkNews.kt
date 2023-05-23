package com.yosuahaloho.retrokoran.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yosuahaloho.retrokoran.domain.model.Article
import com.yosuahaloho.retrokoran.domain.model.Source

/**
 * Created by Yosua on 22/05/2023
 */
@Entity(tableName = "bookmark_news")
data class BookmarkNews(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo("author")
    val author: String,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("url")
    val url: String,
    @ColumnInfo("urlToImage")
    val urlToImage: String,
    @ColumnInfo("publishedAt")
    val publishedAt: String,
    @ColumnInfo("content")
    val content: String
)
