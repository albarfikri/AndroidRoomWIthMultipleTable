package com.albar.relationaldbroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.albar.relationaldbroom.entities.Director
import com.albar.relationaldbroom.entities.School

@Dao
interface SchoolDao {
    // suspend as the database should be executed on the background
    // each database operation should be executed on the beackground to not block the main thread(ui thread)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)
}