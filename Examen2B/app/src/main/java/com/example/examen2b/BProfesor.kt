package com.example.examen2b

import java.io.Serializable

class BProfesor (var nombreProfesor: String?,
                 var materia: String?,
                 var edadProfesor:Int?,
                 var estadoCivil: String?,
                 var telefono: String?): Serializable {
    override fun toString(): String {
        return "Nombre:$nombreProfesor\n" +
                "Materia:$materia\nEdad:$edadProfesor\nEstado Civil:$estadoCivil\nTeléfono:$telefono"
    }
}