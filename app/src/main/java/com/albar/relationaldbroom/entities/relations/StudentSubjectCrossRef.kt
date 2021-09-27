package com.albar.relationaldbroom.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCrossRef(
    // both of these variables are primary key
    // primary key of studentTable
    val studentName: String,
    // primary key of subjectTable
    val subjectName: String
)