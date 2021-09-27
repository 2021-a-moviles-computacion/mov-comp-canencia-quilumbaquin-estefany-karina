package com.example.examen2b
import java.io.Serializable


class BEstudiante(var nombreEstudiante: String? ="",
                  var Edad:Int?=0,
                  var segunda: String? ="",
                  var fechaRegistro: String?="",
                  var Calificacion: Double?=0.0,
                  var altitud: Double?=0.0,
                  var latitud: Double?=0.0
) : Serializable {

    override fun toString(): String {
        return "Nombre: $nombreEstudiante\nEdad: $Edad \nMatricula:$segunda\nFechaRegistro: $fechaRegistro\n" +
                "Calificación: $Calificacion"
    }
}
