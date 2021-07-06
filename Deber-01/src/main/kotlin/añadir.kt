import java.io.File
import kotlin.collections.ArrayList

fun ingresarEstudiante( estudiante: ArrayList<Estudiante> = arrayListOf()) {
    val i: Int
    //var estudiante: ArrayList<Estudiante> = arrayListOf()
    var nombre: String
    var edad: Int
    var nota: Double


    println("INGRESAR DATOS DEL ESTUDIANTE")
    println("\n¿Desea ingresar datos?")
    var ingreso = readLine().toString()

    while (ingreso == "si") {
        print("Nombres:  ")
        nombre = readLine().toString()
        print("Edad:  ")
        edad = readLine()?.toInt() as Int
        print("Calificación  ")
        nota = readLine()?.toDouble() as Double
        print("Es segunda matrícula? true/false:  ")
        var segunda: Boolean = readLine().toBoolean()

        estudiante.add(Estudiante(nombre, edad, segunda, nota))

        println("\n¿Desea ingresar datos?")
        ingreso = readLine().toString()
    }
}

fun añadir(fName :String, args: java.util.ArrayList<Estudiante> = arrayListOf()) {
    for(i in args.indices){
        File(fName).appendText("${args[i].Edad}" + "          "+ args[i].segunda +
                "              "+args[i].calificacion +"              "+ args[i].fechaRegistro+ "           "+"${args[i].Nombre}")}
}


