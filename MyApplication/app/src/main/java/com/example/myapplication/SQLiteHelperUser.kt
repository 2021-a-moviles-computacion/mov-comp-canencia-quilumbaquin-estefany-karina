package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLiteHelperUser (
    context: Context?,
    ) : SQLiteOpenHelper(
    context,
    "moviles",
    null,
    1)
    {
        override fun onCreate(db: SQLiteDatabase?) {
            val scriptCrearTablaProfesor = """ 
            CREATE TABLE PROFESOR (
                id INTEGER PRIMARY KEY AUTOINCREMENT, 
                nombre VARCHAR(50),
                descripcion VARCHAR(50)
            )            
        """.trimIndent()
            Log.i("bdd","Creando la tabla de usuario")

            db?.execSQL(scriptCrearTablaProfesor)}

        fun crearProfesorFormulario(
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

        fun consultarUsuarioPorId(id: Int): BProfesor{
            //var
            val scriptConsultarUsuario = "SELECT * FROM PROFESOR WHERE ID = ${id}"
            val baseDatosLectura = readableDatabase
            val resultadoConsultaLectura = baseDatosLectura.rawQuery(
                scriptConsultarUsuario,
                null
            )
            val existeUsuario = resultadoConsultaLectura.moveToFirst()
            val usuarioEncontrado = BProfesor(0,"","",0,"","")
            if (existeUsuario){
                do{
                    val id = resultadoConsultaLectura.getInt(0) //Columna indice 0 -> ID
                    val nombre = resultadoConsultaLectura.getString(1) //Columna indice 1 -> NOMBRE
                    val materia = resultadoConsultaLectura.getString(2) //Columna indice 2 -> DESCRIPCION
                    val edad = resultadoConsultaLectura.getInt(3) //Columna indice 2 -> DESCRIPCION
                    val estadoCivil = resultadoConsultaLectura.getString(4) //Columna indice 2 -> DESCRIPCION
                    val telefono = resultadoConsultaLectura.getString(5) //Columna indice 2 -> DESCRIPCION


                    if(id!=null){
                        usuarioEncontrado.id = id
                        usuarioEncontrado.nombre = nombre
                        usuarioEncontrado.materia =  materia
                        usuarioEncontrado.edad = edad
                        usuarioEncontrado.estadoCivil = estadoCivil
                        usuarioEncontrado.telefono = telefono
                        //arregloUsuario.add(usuarioEncontrado)
                    }
                }while (resultadoConsultaLectura.moveToNext())
            }
            resultadoConsultaLectura.close()
            baseDatosLectura.close()
            return usuarioEncontrado
        }

        fun eliminarProfesorFormulario (id: Int): Boolean {

            //val conexionEscritura = this.writableDatabase
            val conexionEscritura = writableDatabase
            var resultadoEliminacion = conexionEscritura
                .delete(
                    "PROFESOR",
                    "id=?",
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
            valoresActualizar.put("descripcion", materia)
            valoresActualizar.put("edad",edad)
            valoresActualizar.put("estadoCivil", estadoCivil)
            valoresActualizar.put("telefono",telefono)
            val resultadoActualizacion = conexionEscritura.update(
                "PROFESOR",
                valoresActualizar,
                "id=?",
                arrayOf(id.toString())
            )
            conexionEscritura.close()
            return if (resultadoActualizacion == -1) false else true
        }



        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {


        }
}