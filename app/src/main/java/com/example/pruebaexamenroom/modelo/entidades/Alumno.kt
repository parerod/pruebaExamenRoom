package com.example.pruebaexamenroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName="alumno",
    foreignKeys = [
        ForeignKey(
            entity = Grupo::class,
            parentColumns = ["idGrupo"],
            childColumns = ["grupoId"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Alumno(
    @ColumnInfo(name = "nombre")
    var nombre : String,
    @ColumnInfo(name="apellido")
    var apellido : String,
    @ColumnInfo(name="grupoId")
    var grupoId : String
){

    @ColumnInfo(name="idAlumno")
    @PrimaryKey(autoGenerate = true)
    var idAlumno : Int= 0

    override fun toString(): String {
        return "ID = $idAlumno, NOMBRE = $nombre"
    }

}