import java.io.File
import java.text.DateFormat
import java.util.*
import kotlin.collections.ArrayList

fun profesor() {
    var profesor: Profesor
    var i=Int

    profesor=(Profesor("Esteban Lopez","Redes",34,'S',"2380453"))
    println("NombreProfesor:   ${profesor.nombre}")
    println("Materia:          ${profesor.materia}")
    println("Edad:             ${profesor.Edad}")
    println("Estado Civil:     ${profesor.EstadoCivil}")
    println("Teléfono:         ${profesor.telefono}\n\n")
}

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
        File(fName).appendText("\n"+args[i].Nombre+"      "+ args[i].Edad +"     "+ args[i].segunda +
                "     "+args[i].calificacion +"     "+ args[i].fechaRegistro)}
}


