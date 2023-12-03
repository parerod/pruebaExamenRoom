package com.example.pruebaexamenroom.modelo.conexiones

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pruebaexamenroom.modelo.entidades.*
import com.example.pruebaexamenroom.modelo.interfaces.*

@Database(entities = [Alumno::class, Asignatura::class,Grupo::class, Matricula::class, Departamento::class, Profesor::class], version = 2)
abstract class AppDB : RoomDatabase() {
    abstract fun DaoAlumno(): InterfaceDaoAlumno
    abstract fun DaoAsignatura(): InterfaceDaoAsignatura
    abstract fun DaoGrupo(): InterfaceDaoGrupo
    abstract fun DaoDepartamento(): InterfaceDaoDepartamento
    abstract fun DaoProfesor(): InterfaceDaoProfesor
    abstract fun DaoMatricula(): InterfaceDaoMatricula

    companion object {
        private var INSTANCE: AppDB? = null
        fun getBaseDatos(context: Context): AppDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "examen22DB"
                ).allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build()
                //Con migracion hay que incrementar la version y añadirle que migracion
                /*INSTANCE = Room.databaseBuilder(context.getApplicationContext(),BaseDatos.class,
                    "DietaBD").addMigrations(MIGRATION1_2).allowMainThreadQueries().build();*/
            }
            return INSTANCE as AppDB
        }

        val MIGRATION_1_2: Migration = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE departamento (idDepartamento TEXT NOT NULL, nombre TEXT NOT NULL")
                database.execSQL("CREATE TABLE profesor (idProfesor INTEGER NOT NULL, nombre TEXT NOT NULL, departamentoID TEXT NOT NULL")
            }
        }
    }






}
