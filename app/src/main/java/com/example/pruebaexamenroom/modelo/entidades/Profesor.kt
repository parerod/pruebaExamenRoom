package com.example.pruebaexamenroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName="profesor",
    foreignKeys = [
        ForeignKey(
            entity = Departamento::class,
            parentColumns = ["idDepartamento"],
            childColumns = ["departamentoId"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Profesor (

    @ColumnInfo(name="nombre")
    var nombre : String,
    @ColumnInfo(name="departamentoId")
    var departamentoId : String
        ) {

    @ColumnInfo(name="idProfesor")
    @PrimaryKey(autoGenerate = true)
    var idProfesor : Int= 0
}