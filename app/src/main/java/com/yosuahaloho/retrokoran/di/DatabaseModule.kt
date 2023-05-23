package com.yosuahaloho.retrokoran.di

import android.content.Context
import androidx.room.Room
import com.yosuahaloho.retrokoran.data.local.db.BookmarkNewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Yosua on 22/05/2023
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabaseBookmark(
        @ApplicationContext context: Context
    ): BookmarkNewsDatabase {
        return Room.databaseBuilder(
            context,
            BookmarkNewsDatabase::class.java,
            "bookmark_database"
        ).build()
    }
}