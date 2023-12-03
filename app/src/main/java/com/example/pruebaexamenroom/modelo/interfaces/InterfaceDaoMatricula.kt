package com.example.pruebaexamenroom.modelo.interfaces

import androidx.room.*
import com.example.pruebaexamenroom.modelo.entidades.Alumno
import com.example.pruebaexamenroom.modelo.entidades.Asignatura
import com.example.pruebaexamenroom.modelo.entidades.Matricula

@Dao
interface InterfaceDaoMatricula {

    @Insert
    fun addMatricula(mat : Matricula)

    @Query("SELECT * FROM matricula")
    fun getMatriculas() : MutableList<Matricula>

    @Query("SELECT alu.* FROM alumno alu JOIN matricula mat ON mat.alumnoId = alu.idAlumno JOIN asignatura asig ON asig.idAsignatura = mat.asignaturaId WHERE asig.nombre = :nombreAsig")
    fun getAlumnosAsignaturas(nombreAsig : String) : MutableList<Alumno>

    @Update
    fun updateMatricula(mat: Matricula)

    @Delete
    fun deleteMatricula(mat: Matricula)

    @Query("DELETE FROM matricula")
    fun borrarTabla()

}