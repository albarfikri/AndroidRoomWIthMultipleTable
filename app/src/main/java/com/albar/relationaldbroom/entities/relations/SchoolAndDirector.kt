package com.albar.relationaldbroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.albar.relationaldbroom.entities.Director
import com.albar.relationaldbroom.entities.School

data class SchoolAndDirector(
    // Embeded to include the fields from school to SchoolAndDirector
    @Embedded val school: School,
    @Relation(
        // parentColumn is the place where all of atribut belong together
        parentColumn = "schoolName",
        // Entity Column come from the parent foreign key that's in the child
        entityColumn = "schoolName"
    )
    val director: Director
)