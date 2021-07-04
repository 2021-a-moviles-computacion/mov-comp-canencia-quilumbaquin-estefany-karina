
fun main() {
    var Datosestudiante: ArrayList<Estudiante> = arrayListOf()
    var datosProfesor: Profesor
    //var nombre: String
    //nombre = readLine().toString()
    var accion: String
    println("Ingrese una acción")
    accion = readLine().toString()


    if(accion == "Crear"){}
    if(accion == "Eliminar"){}
    if(accion == "Ingresar"){
        ingresarEstudiante(Datosestudiante)
    }
    if(accion == "Actualizar"){
        println("Se ha actualizado la lista")
    }
}

