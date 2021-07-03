fun imprimir() {
    var profesor: Profesor
    var i=Int
    var estudiante: ArrayList<Estudiante> = arrayListOf()

    estudiante.add(Estudiante("sss",12,true,2.4))
    estudiante.add(Estudiante("ddsd",12,true,2.4))

    println("LISTA DE ESTUDIANTES")
    for(i in 0 ..1){
        println(estudiante[i].Nombre+"     "+estudiante[i].Edad+"     "+estudiante[i].segunda+"    "+
        estudiante[i].calificacion+"     "+estudiante[i].fechaIngreso)
    }
}

fun ingresarEstudiante(){
    val i: Int
    val estudiante: Estudiante
    val nombre: String = readLine().toString()
    val edad: Int = readLine()?.toInt() as Int
    val segunda: Boolean
    val nota: Double = readLine()?.toDouble() as Double
    val mat: String = readLine().toString()

    println("INGRESAR DATOS DEL ESTUDIANTE")

    println("Nombres:  "+ nombre)
    println("Edad:  "+ edad)
    println("Es segunda Matricula?:  "+mat)
    println("Calificación  "+ nota)

    if(mat == "si"){
        segunda = true
    }else if (mat == "no"){
        segunda=false }

    //estudiante = Estudiante(readLine().toString(), readLine()?.toInt() as Int, true, readLine()?.toDouble() as Double)
}


