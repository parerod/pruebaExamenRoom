package com.example.pruebaexamenroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="departamento")
data class Departamento(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name="idDepartamento")
    var idDepartamento : String,
    @ColumnInfo(name="nombre")
    var nombre : String



    ) {
}