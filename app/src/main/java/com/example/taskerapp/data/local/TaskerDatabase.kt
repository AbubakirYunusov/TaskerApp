package com.example.taskerapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskerapp.data.local.models.TaskModelCache

@Database(
    entities = [TaskModelCache::class],
    version = 1,
)
abstract class TaskerDatabase: RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

}