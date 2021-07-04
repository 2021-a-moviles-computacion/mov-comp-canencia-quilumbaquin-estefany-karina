fun imprimir(estudiante: ArrayList<Estudiante> = arrayListOf()) {
    var profesor: Profesor
    var i=Int

    profesor=(Profesor("Esteban Lopez","Redes",34,'S',"2380453"))
    println("NombreProfesor:   ${profesor.nombre}")
    println("Materia:          ${profesor.materia}")
    println("Edad:             ${profesor.Edad}")
    println("Estado Civil:     ${profesor.EstadoCivil}")
    println("Teléfono:         ${profesor.telefono}")


    println("\nLISTA DE ESTUDIANTES\n")
    for(i in estudiante.indices){
        println(estudiante[i].Nombre+"     "+estudiante[i].Edad+"     "+estudiante[i].segunda+"    "+
        estudiante[i].calificacion+"     "+estudiante[i].fechaIngreso)
    }
}

fun ingresarEstudiante(estudiante: ArrayList<Estudiante> = arrayListOf()) {
    val i: Int
    //var estudiante: ArrayList<Estudiante> = arrayListOf()
    var nombre: String
    var edad: Int
    var nota: Double

    println("INGRESAR DATOS DEL ESTUDIANTE")
    println("\n¿Desea ingresar datos?")
    var ingreso = readLine().toString()

    while (ingreso == "si") {
        println("Nombres:  ")
        nombre = readLine().toString()
        println("Edad:  ")
        edad = readLine()?.toInt() as Int
        println("Calificación  ")
        nota = readLine()?.toDouble() as Double

        estudiante.add(Estudiante(nombre, edad, true, nota))

        println("\n¿Desea ingresar datos?")
        ingreso = readLine().toString()
    }
}


