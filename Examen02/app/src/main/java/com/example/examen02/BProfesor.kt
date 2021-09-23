package com.example.examen2b

import java.io.Serializable

class BProfesor(var nombreProfesor: String?,
                var materia: String?,
                var edadProfesor:Int?,
                var estadoCivil: String?,
                var telefono: String?): Serializable {
    override fun toString(): String {
        return " Nombre:$nombreProfesor   materia:$materia  Edad:$edadProfesor  Estado Civil:$estadoCivil   Teléfono:$telefono"
    }
}