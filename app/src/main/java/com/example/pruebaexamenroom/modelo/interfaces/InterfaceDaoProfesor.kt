package com.example.pruebaexamenroom.modelo.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pruebaexamenroom.modelo.entidades.Alumno
import com.example.pruebaexamenroom.modelo.entidades.Profesor

@Dao
interface InterfaceDaoProfesor {

        @Insert
        fun addProfesor(prof : Profesor)

        @Query("SELECT * FROM profesor")
        fun getProfesores() : MutableList<Profesor>

        @Query("SELECT * FROM profesor WHERE nombre LIKE :nombre")
        fun getProfesorNombre(nombre: String) : Profesor

        @Update
        fun updateProfesor(prof : Profesor)

        @Delete
        fun deleteProfesor(prof:Profesor)

        @Query("DELETE FROM profesor")
        fun borrarTablaProfesor()

}