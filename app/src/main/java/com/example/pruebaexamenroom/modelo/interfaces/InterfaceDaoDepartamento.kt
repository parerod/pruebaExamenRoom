package com.example.pruebaexamenroom.modelo.interfaces

import androidx.room.*
import com.example.pruebaexamenroom.modelo.entidades.Asignatura
import com.example.pruebaexamenroom.modelo.entidades.Departamento
import com.example.pruebaexamenroom.modelo.entidades.Grupo

@Dao
interface InterfaceDaoDepartamento {

    @Insert
    fun addDepartamento(depa: Departamento)

    @Query("SELECT * FROM departamento")
    fun getDepartamentos() : MutableList<Departamento>

    @Query("SELECT * FROM departamento WHERE nombre LIKE :nombre")
    fun getDepartamentoNombre(nombre: String) : Departamento

    @Update
    fun updateDepartamento(depa: Departamento)

    @Delete
    fun deleteDepartamento(depa: Departamento)

    @Query("DELETE FROM departamento")
    fun borrarTabla()

}