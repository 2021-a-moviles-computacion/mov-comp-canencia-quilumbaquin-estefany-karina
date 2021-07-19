package com.example.examen_01

import android.os.Parcel
import android.os.Parcelable
import java.text.SimpleDateFormat

class BProfesor( var idProfesor:Int,
                 var nombreProfesor: String?,
                 var materia: String?,
                 var edadProfesor:Int?,
                 var estadoCivil: String?,
                 var telefono: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idProfesor)
        parcel.writeString(nombreProfesor)
        parcel.writeString(materia)
        parcel.writeInt(edadProfesor!!)
        parcel.writeString(estadoCivil!!)
        parcel.writeString(telefono)
        //parcel.writeString(SimpleDateFormat("dd/MM/yyyy").format(telefono))

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "IdProfesor:  $idProfesor \n" +
                "Nombre:     $nombreProfesor \n" +
                "Dirección:  $materia \n" +
                "Edad:       $edadProfesor \n" +
                "EstadoCivil:$estadoCivil \n" +
                "Telefono:   $telefono "
    }

    companion object CREATOR : Parcelable.Creator<BProfesor> {
        override fun createFromParcel(parcel: Parcel): BProfesor {
            return BProfesor(parcel)
        }

        override fun newArray(size: Int): Array<BProfesor?> {
            return arrayOfNulls(size)
        }
    }



}