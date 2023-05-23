package com.yosuahaloho.retrokoran.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yosuahaloho.retrokoran.data.local.dao.BookmarkNewsDao
import com.yosuahaloho.retrokoran.data.local.entity.BookmarkNews
import com.yosuahaloho.retrokoran.domain.model.Article

/**
 * Created by Yosua on 22/05/2023
 */
@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class BookmarkNewsDatabase : RoomDatabase() {

    abstract fun bookmarkNewsDao(): BookmarkNewsDao

}