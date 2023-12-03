package com.example.pruebaexamenroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="grupo")
data class Grupo(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name="idGrupo")
    var idGrupo : String,
    @ColumnInfo(name="nombre")
    var nombre : String,
    @ColumnInfo(name = "aula")
    var aula : String
){

}