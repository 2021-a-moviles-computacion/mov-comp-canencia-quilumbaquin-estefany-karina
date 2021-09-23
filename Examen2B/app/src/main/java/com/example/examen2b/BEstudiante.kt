package com.example.examen2b

import java.io.Serializable

class BEstudiante(var nombreEstudiante: String?,
                  var Edad:Int,
                  var segunda: String?,
                  var fechaRegistro: String?,
                  var Calificacion: Double,
                  var altitud: Double,
                  var latitud: Double
): Serializable {

    override fun toString(): String {
        return "Nombre: $nombreEstudiante   Edad: $Edad   Matricula:$segunda   FechaRegistro: $fechaRegistro  Calificación: $Calificacion"
    }
}