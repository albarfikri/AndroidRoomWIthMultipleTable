package com.albar.relationaldbroom.dao

import androidx.room.*
import com.albar.relationaldbroom.entities.Director
import com.albar.relationaldbroom.entities.School
import com.albar.relationaldbroom.entities.relations.SchoolAndDirector

@Dao
interface SchoolDao {
    // suspend as the database should be executed on the background
    // each database operation should be executed on the beackground to not block the main thread(ui thread)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchooName(schoolName: String): List<SchoolAndDirector>

}