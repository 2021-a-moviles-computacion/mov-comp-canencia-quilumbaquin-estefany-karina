fun imprimir(estudiante: ArrayList<Estudiante> = arrayListOf()) {
    var profesor: Profesor
    var i=Int
    //var estudiante: ArrayList<Estudiante> = arrayListOf()
    //estudiante.add(Estudiante("sss",12,true,2.4))
    //estudiante.add(Estudiante("ddsd",12,true,2.4))

    println("LISTA DE ESTUDIANTES")
    for(i in estudiante.indices){
        println(estudiante[i].Nombre+"     "+estudiante[i].Edad+"     "+estudiante[i].segunda+"    "+
        estudiante[i].calificacion+"     "+estudiante[i].fechaIngreso)
    }
}

fun ingresarEstudiante(estudiante: ArrayList<Estudiante> = arrayListOf()){
    val i: Int
    //var estudiante: ArrayList<Estudiante> = arrayListOf()
    var nombre: String
    var edad: Int
    var nota: Double

    println("INGRESAR DATOS DEL ESTUDIANTE")
    println("desea ingresar datos")
    var ingreso = readLine().toString()

    while (ingreso == "si"){
        println("Nombres:  ")
        nombre = readLine().toString()
        println("Edad:  ")
        edad = readLine()?.toInt() as Int
        println("Calificación  ")
        nota = readLine()?.toDouble() as Double

        estudiante.add(Estudiante(nombre, edad, true, nota))

        println("desea ingresar datos")
        ingreso = readLine().toString()
    }
    imprimir(estudiante)

}


