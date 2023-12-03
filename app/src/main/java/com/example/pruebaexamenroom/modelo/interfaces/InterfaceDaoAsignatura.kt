package com.example.pruebaexamenroom.modelo.interfaces

import androidx.room.*
import com.example.pruebaexamenroom.modelo.entidades.Alumno
import com.example.pruebaexamenroom.modelo.entidades.Asignatura

@Dao
interface InterfaceDaoAsignatura {

    @Insert
    fun addAsignatura(asig: Asignatura)

    @Query("SELECT * FROM asignatura")
    fun getAsignaturas() : MutableList<Asignatura>

    @Query("SELECT * FROM asignatura WHERE nombre LIKE :nombre")
    fun getAsignaturaNombre(nombre: String) : Asignatura

    @Update
    fun updateAsignatura(asig: Asignatura)

    @Delete
    fun deleteAsignatura(asig: Asignatura)

    @Query("DELETE FROM asignatura")
    fun borrarTabla()

}