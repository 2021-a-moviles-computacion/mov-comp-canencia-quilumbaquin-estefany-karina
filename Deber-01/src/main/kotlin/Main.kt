
fun main() {
    var Datosestudiante: ArrayList<Estudiante> = arrayListOf()
    var datosProfesor: Profesor
    var accion: String
    println("Ingrese una acción")
    accion = readLine().toString()


    if(accion == "Crear"){
        read(Datosestudiante)
    }
    if(accion == "Eliminar"){}
    if(accion == "Ingresar"){
        ingresarEstudiante(Datosestudiante)
        imprimir(Datosestudiante)
        create(Datosestudiante)
    }
    if(accion == "Actualizar"){
        update(Datosestudiante)
        //println("Se ha actualizado la lista")
    }
}

