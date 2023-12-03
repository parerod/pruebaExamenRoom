package com.example.pruebaexamenroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pruebaexamenroom.modelo.conexiones.AppDB
import com.example.pruebaexamenroom.modelo.entidades.*
import com.example.pruebaexamenroom.modelo.interfaces.*

class MainActivity : AppCompatActivity() {

    lateinit var conexion : AppDB
    lateinit var daoAlumno : InterfaceDaoAlumno
    lateinit var daoAsignatura: InterfaceDaoAsignatura
    lateinit var daoDepartamento: InterfaceDaoDepartamento
    lateinit var daoGrupo: InterfaceDaoGrupo
    lateinit var daoProfesor: InterfaceDaoProfesor
    lateinit var daoMatricula: InterfaceDaoMatricula

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
        borrarDatos()
        ingresarDatos()
        borrarDatos()
        consultas()
    }

    fun setup() {
        conexion=AppDB.getBaseDatos(this)
        daoAlumno=conexion.DaoAlumno()
        daoAsignatura=conexion.DaoAsignatura()
        daoDepartamento=conexion.DaoDepartamento()
        daoGrupo=conexion.DaoGrupo()
        daoProfesor=conexion.DaoProfesor()
        daoMatricula=conexion.DaoMatricula()

    }

    fun ingresarDatos() {

        var grupo1 = Grupo("primero","1DAM","HRC")
        var grupo2 = Grupo("segundo","2DAM","GRL")

        var pablo = Alumno("Pablo","Arenas","primero")
        var manu = Alumno("Manuel Jesus","Casado","segundo")

        var informatica = Departamento("informatica","Departamento de Informatica")
        var mates = Departamento("matematicas","Departamento de Matematicas")

        var maria = Profesor("Maria Jose","informatica")
        var dioni = Profesor("Dionisio Penalosa","matematicas")

        var lengua = Asignatura("Lengua")
        var prog = Asignatura("Programacion")



        daoGrupo.addGrupo(grupo1)
        daoGrupo.addGrupo(grupo2)

        daoAlumno.addAlumno(pablo)
        daoAlumno.addAlumno(manu)

        daoDepartamento.addDepartamento(informatica)
        daoDepartamento.addDepartamento(mates)

        daoProfesor.addProfesor(maria)
        daoProfesor.addProfesor(dioni)

        daoAsignatura.addAsignatura(lengua)
        daoAsignatura.addAsignatura(prog)

        var matricula1 = Matricula(daoAlumno.getAlumno("Pablo").idAlumno,daoAsignatura.getAsignaturaNombre("Lengua").idAsignatura)
        var matricula2 = Matricula(daoAlumno.getAlumno("Pablo").idAlumno,daoAsignatura.getAsignaturaNombre("Programacion").idAsignatura)

        daoMatricula.addMatricula(matricula1)
        daoMatricula.addMatricula(matricula2)

    }

    fun consultas() {
        var alums = daoMatricula.getAlumnosAsignaturas("Lengua")

        for(i in 0.. alums.size) {
            Log.d("prueba1",i.toString())
        }
    }

    fun borrarDatos() {

        daoMatricula.borrarTabla()
        daoAlumno.borrarTabla()
        daoGrupo.borrarTabla()
        daoDepartamento.borrarTabla()
        daoProfesor.borrarTablaProfesor()
        daoAsignatura.borrarTabla()
    }


}