package com.example.pruebaexamenroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="asignatura")
data class Asignatura(

    @ColumnInfo(name="nombre")
    var nombre : String
) {

    @ColumnInfo(name="idAsignatura")
    @PrimaryKey(autoGenerate = true)
    var idAsignatura : Int= 0

}