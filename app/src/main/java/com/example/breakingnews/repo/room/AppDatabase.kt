package com.example.breakingnews.repo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.breakingnews.model.Article


@Database(entities = [Article::class], version = 1, exportSchema = false)
@TypeConverters(AppConverter::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        var database: AppDatabase? = null
            private set

        fun initDatabase(context: Context) {
            if (database == null) {
                val builder = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "breaking_news_db")
                database = builder.build()
            }
        }
    }
    abstract fun headlineDAO(): HeadlineDAO
}