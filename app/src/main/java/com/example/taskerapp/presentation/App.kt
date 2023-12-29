package com.example.taskerapp.presentation

import android.app.Application
import androidx.room.Room
import com.example.taskerapp.data.local.TaskerDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            TaskerDatabase::class.java,
            "tasker_app_database"
        ).allowMainThreadQueries()
            .build()
    }

    companion object {
        lateinit var database: TaskerDatabase
    }
}