package com.albar.relationaldbroom.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.albar.relationaldbroom.entities.Student
import com.albar.relationaldbroom.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)