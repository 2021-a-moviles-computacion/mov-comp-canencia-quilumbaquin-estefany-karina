package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.examen_01.BProfesor
import java.text.SimpleDateFormat
import java.util.*

class SQLiteHelper(context: Context):SQLiteOpenHelper(context,"examen",null,1) {

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
            )
            """.trimIndent()
        Log.i("bdd", "Creacion tabla profesor")
        db?.execSQL(scriptCrearTablaProfesor)

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
        val scriptConsultarUsuario = "SELECT * FROM PROFESOR"
        val baseDatosLectura = readableDatabase
        val resultaConsultaLectura = baseDatosLectura.rawQuery(scriptConsultarUsuario, null)
        val existeUsuario = resultaConsultaLectura.moveToFirst()
        var arregloProfesor = arrayListOf<BProfesor>()

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
                            //SimpleDateFormat("dd/MM/yyyy").parse(resultaConsultaLectura.getString(5))
                        ))
                }
            }while(resultaConsultaLectura.moveToNext())
        }

        resultaConsultaLectura.close()
        baseDatosLectura.close()
        return arregloProfesor
    }

    fun eliminarProfesorFormulario (id: Int): Boolean {

        //val conexionEscritura = this.writableDatabase
        val conexionEscritura = writableDatabase
        var resultadoEliminacion = conexionEscritura
            .delete(
                "PROFESOR",
                "ID_PROFESOR=?",
                arrayOf(id.toString())
            )
        conexionEscritura.close()
        return if (resultadoEliminacion.toInt() == -1) false else true
    }

    fun actualizarProfesorFormulario (nombre :String,
                                      materia:String,
                                      edad: Int,
                                      estadoCivil: String,
                                      telefono: String,
                                      id :Int):Boolean {

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


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}