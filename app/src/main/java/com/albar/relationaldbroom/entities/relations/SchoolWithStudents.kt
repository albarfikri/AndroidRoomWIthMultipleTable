package com.albar.relationaldbroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.albar.relationaldbroom.entities.School
import com.albar.relationaldbroom.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        // primary key of school table
        parentColumn = "schoolName",
        // in 1 to 1 and 1 to many entityColumn = parentColumn
        entityColumn = "schoolName"
    )
    val students: List<Student>
)