package com.example.examen_01

import android.os.Parcel
import android.os.Parcelable


class BEstudiante(
    var idEstudiante:Int,
    var idProfesor: Int,
    var nombreEstudiante: String?,
    var Edad:Int,
    var segunda: String?,
    var fechaRegistro: String?,
    var Calificacion: Double
): Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
    ) {
    }

    override fun toString(): String {
        return "IdProfesor:         $idProfesor\n" +
                "IdEstudiante:      $idEstudiante\n"+
                "Nombre :           $nombreEstudiante\n" +
                "Edad :             $Edad \n"+
                "Segunda Matrícula?:$segunda\n" +
                "Fecha de registro: $fechaRegistro\n " +
                "Calificación:      $Calificacion \n"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idEstudiante)
        parcel.writeInt(idProfesor)
        parcel.writeString(nombreEstudiante)
        parcel.writeInt(Edad)
        parcel.writeString(segunda)
        parcel.writeString(fechaRegistro)
        parcel.writeDouble(Calificacion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BEstudiante> {
        override fun createFromParcel(parcel: Parcel): BEstudiante {
            return BEstudiante(parcel)
        }

        override fun newArray(size: Int): Array<BEstudiante?> {
            return arrayOfNulls(size)
        }
    }
}