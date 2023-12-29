package com.example.taskerapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskerapp.data.local.models.TaskModelCache

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewTask(taskModelCache: TaskModelCache)

    @Query("SELECT * FROM task_table_name")
    fun getAllTasks(): List<TaskModelCache>

}