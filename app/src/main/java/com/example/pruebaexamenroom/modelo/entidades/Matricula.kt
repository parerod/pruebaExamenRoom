package com.example.pruebaexamenroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName="matricula",
    primaryKeys = ["alumnoId", "asignaturaId"],
    foreignKeys = [
        ForeignKey(
            entity = Alumno::class,
            parentColumns = ["idAlumno"],
            childColumns = ["alumnoId"]
        ),
        ForeignKey(
            entity = Asignatura::class,
            parentColumns = ["idAsignatura"],
            childColumns = ["asignaturaId"]
        )
    ]
)
data class Matricula(
    @ColumnInfo(name="alumnoId")
    var alumnoId : Int,
    @ColumnInfo(name = "asignaturaId")
    var asignaturaId : Int
) {
}