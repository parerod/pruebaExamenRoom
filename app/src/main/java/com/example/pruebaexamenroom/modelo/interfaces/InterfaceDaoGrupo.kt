package com.example.pruebaexamenroom.modelo.interfaces

import androidx.room.*
import com.example.pruebaexamenroom.modelo.entidades.Asignatura
import com.example.pruebaexamenroom.modelo.entidades.Grupo

@Dao
interface InterfaceDaoGrupo {

    @Insert
    fun addGrupo(grup: Grupo)

    @Query("SELECT * FROM grupo")
    fun getGrupos() : MutableList<Grupo>

    @Query("SELECT * FROM grupo WHERE nombre LIKE :nombre")
    fun getGrupoNombre(nombre: String) : Grupo

    @Update
    fun updateGrupo(grup: Grupo)

    @Delete
    fun deleteGrupo(grup: Grupo)

    @Query("DELETE FROM grupo")
    fun borrarTabla()

}