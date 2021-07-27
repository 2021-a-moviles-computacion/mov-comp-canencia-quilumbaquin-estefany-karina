package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.examen_01.BEstudiante
import com.example.examen_01.BProfesor
import java.util.*

class SQLiteHelper(context: Context?):SQLiteOpenHelper(context,"examen.db",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val scriptCrearTablaProfesor=
            """
            CREATE TABLE PROFESOR(
            ID_PROFESOR INTEGER PRIMARY KEY AUTOINCREMENT,
            NOMBRE VARCHAR(50),
            MATERIA VARCHAR(50),
            EDAD INTEGER,
            ESTADOCIVIL VARCHAR(10),
            TELEFONO VARCHAR(10)
            );
            """.trimIndent()
        Log.i("bdd", "Creacion tabla profesor")
        db?.execSQL(scriptCrearTablaProfesor)

        val scriptCrearTablaEstudiante=
            """
            CREATE TABLE ESTUDIANTE(
            ID_ESTUDIANTE INTEGER PRIMARY KEY AUTOINCREMENT,
            ID_PROF INTEGER,
            NOMBRE VARCHAR(50),
            EDAD INTEGER,
            SEGUNDA VARCHAR(5),
            FECHAREGISTRO VARCHAR(15),
            CALIFICACION DOUBLE,
            FOREIGN KEY(ID_PROF) REFERENCES PROFESOR(ID_PROFESOR) 
            );
            """.trimIndent()
        Log.i("bdd", "Creacion tabla Estudiante")
        db?.execSQL(scriptCrearTablaEstudiante)
    }


    fun crearProfesor(
        nombre: String,
        materia: String,
        edad: Int,
        estadoCivil: String,
        telefono: String
    ): Boolean{
        val conexionEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre", nombre)
        valoresAGuardar.put("materia", materia)
        valoresAGuardar.put("edad",edad)
        valoresAGuardar.put("estadoCivil", estadoCivil)
        valoresAGuardar.put("telefono", telefono)
        val resultadoEscritura: Long = conexionEscritura
            .insert(
                "PROFESOR",
                null,
                valoresAGuardar
            )
        conexionEscritura.close()
        return if (resultadoEscritura.toInt() == -1) false else true
    }


    fun consultarProfesores(): ArrayList<BProfesor> {
        val scriptConsultarProf = "SELECT * FROM PROFESOR"
        val baseDatosLectura = readableDatabase
        val resultaConsultaLectura = baseDatosLectura.rawQuery(scriptConsultarProf, null)
        val existeUsuario = resultaConsultaLectura.moveToFirst()
        val arregloProfesor = arrayListOf<BProfesor>()

        if(existeUsuario){
            do{
                val id = resultaConsultaLectura.getInt(0)
                if(id!=null){
                    arregloProfesor.add(
                        BProfesor(id,
                            resultaConsultaLectura.getString(1),
                            resultaConsultaLectura.getString(2),
                            resultaConsultaLectura.getInt(3),
                            resultaConsultaLectura.getString(4),
                            resultaConsultaLectura.getString(5)
                        ))
                }
            }while(resultaConsultaLectura.moveToNext())
        }

        resultaConsultaLectura.close()
        baseDatosLectura.close()
        return arregloProfesor
    }

    fun eliminarProfesorFormulario (id: Int): Boolean {

        val conexionEscritura = writableDatabase
        val resultadoEliminacion = conexionEscritura
            .delete(
                "PROFESOR",
                "ID_PROFESOR=?",
                arrayOf(id.toString())
            )
        conexionEscritura.close()
        return if (resultadoEliminacion.toInt() == -1) false else true
    }

    fun actualizarProfesorFormulario (
        nombre:String,
        materia:String,
        edad: Int,
        estadoCivil: String,
        telefono: String,
        id:Int):Boolean {

        val conexionEscritura = writableDatabase
        var valoresActualizar = ContentValues()
        valoresActualizar.put("nombre", nombre)
        valoresActualizar.put("materia", materia)
        valoresActualizar.put("edad",edad)
        valoresActualizar.put("estadoCivil", estadoCivil)
        valoresActualizar.put("telefono",telefono)
        val resultadoActualizacion = conexionEscritura.update(
            "PROFESOR",
            valoresActualizar,
            "ID_PROFESOR=?",
            arrayOf(id.toString())
        )
        conexionEscritura.close()
        return if (resultadoActualizacion ==-1) false else true
    }

    //********** FUNCIONES DELA TABLA ESTUDIANTE ***************
    fun crearEstudiante(
        id_profesor: Int,
        nombre: String,
        edad: Int,
        Segunda: String,
        fechaRegistro: String,
        calificacion: Double
    ): Boolean{
        val conexionEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("id_prof", id_profesor)
        valoresAGuardar.put("nombre", nombre)
        valoresAGuardar.put("edad", edad)
        valoresAGuardar.put("segunda",Segunda)
        valoresAGuardar.put("fechaRegistro", fechaRegistro)
        valoresAGuardar.put("calificacion", calificacion)
        val resultadoEscritura: Long = conexionEscritura
            .insert(
                "ESTUDIANTE",
                null,
                valoresAGuardar
            )
        conexionEscritura.close()
        return if (resultadoEscritura.toInt() == -1) false else true
    }


    fun consultarEstudiantesIdProfesor(idProf: Int): ArrayList<BEstudiante> {
        val scriptConsultaProfesor = "SELECT * FROM ESTUDIANTE WHERE ID_PROF = ${idProf}"
        val baseDatosLectura = readableDatabase
        val resultaConsultaLectura = baseDatosLectura.rawQuery(scriptConsultaProfesor, null)
        val existeEstudiante = resultaConsultaLectura.moveToFirst()
        val arregloEstudiante = arrayListOf<BEstudiante>()

        if(existeEstudiante){
            do{
                val id = resultaConsultaLectura.getInt(0)
                if(id!=null){
                    arregloEstudiante.add(
                        BEstudiante(id,idProf,
                            resultaConsultaLectura.getString(2),
                            resultaConsultaLectura.getInt(3),
                            resultaConsultaLectura.getString(4),
                            resultaConsultaLectura.getString(5),
                            resultaConsultaLectura.getDouble(6)
                        )
                    )
                }
            }while(resultaConsultaLectura.moveToNext())
        }
        resultaConsultaLectura.close()
        baseDatosLectura.close()
        return arregloEstudiante
    }


    fun eliminarEstudianteFormulario (id: Int): Boolean {
        val conexionEscritura = writableDatabase
        var resultadoEliminacion = conexionEscritura
            .delete(
                "ESTUDIANTE",
                "ID_ESTUDIANTE=?",
                arrayOf(id.toString())
            )
        conexionEscritura.close()
        return if (resultadoEliminacion.toInt() == -1) false else true
    }

    fun actualizarEstudianteFormulario (nombre :String,
                                      edad: Int,
                                      Segunda: String,
                                      fechaRegistro: String,
                                        Calificación: Double,
                                      id :Int):Boolean {

        val conexionEscritura = writableDatabase
        var valoresActualizar = ContentValues()
        valoresActualizar.put("nombre", nombre)
        valoresActualizar.put("edad", edad)
        valoresActualizar.put("segunda",Segunda)
        valoresActualizar.put("fechaRegistro", fechaRegistro)
        valoresActualizar.put("calificacion",Calificación)
        val resultadoActualizacion = conexionEscritura.update(
            "ESTUDIANTE",
            valoresActualizar,
            "ID_ESTUDIANTE=?",
            arrayOf(id.toString())
        )
        conexionEscritura.close()
        return if (resultadoActualizacion ==-1) false else true
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}