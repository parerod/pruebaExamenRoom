package com.example.pruebaexamenroom.modelo.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pruebaexamenroom.modelo.entidades.Alumno

@Dao
interface InterfaceDaoAlumno {

        @Insert
        fun addAlumno(alumno : Alumno)

        @Query("SELECT * FROM alumno")
        fun getAlumnos() : MutableList<Alumno>

        @Query("SELECT * FROM alumno WHERE nombre LIKE :nombre")
        fun getAlumno(nombre: String) : Alumno

        @Query("SELECT * FROM alumno WHERE grupoId LIKE :grupito")
        fun getAlumnoGrupo(grupito : String) : MutableList<Alumno>

        @Update
        fun updateAlumno(alumno : Alumno)

        @Delete
        fun deleteAlumno(alumno:Alumno)

        @Query("DELETE FROM alumno")
        fun borrarTabla()

}