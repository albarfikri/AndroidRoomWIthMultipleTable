package com.albar.relationaldbroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.albar.relationaldbroom.dao.SchoolDao
import com.albar.relationaldbroom.entities.Director
import com.albar.relationaldbroom.entities.School
import com.albar.relationaldbroom.entities.Student
import com.albar.relationaldbroom.entities.Subject
import com.albar.relationaldbroom.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class,
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile // right to INSTANCE value to be immediately visible for any threads
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            // SYNCHRONIZE makes sure the block inside synchronize being executed only once or with single thread
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also{
                    // to update our instance
                    INSTANCE = it
                }

            }
        }
    }

}