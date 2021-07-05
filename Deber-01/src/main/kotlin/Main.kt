
fun main() {
    var Datosestudiante: ArrayList<Estudiante> = arrayListOf()
    var datosProfesor: Profesor
    var accion: String

    println("Ingrese una acción: \ncrear, \neliminar, \nactualizar(cambiar información-Añadir un nuevo registro), \nleer")
    accion = readLine().toString()


    if(accion == "crear"){
        ingresarEstudiante(Datosestudiante)
        create(Datosestudiante)
        read(Datosestudiante)
    }
    if(accion == "eliminar"){
        //FALTA FUNCION ELIMINAR
    }
    if(accion == "actualizar"){
        println("Ingrese: 1\n para Cambiar información de un registro \n2 para Ingresar un nuevo registro")
        var actualizarR:String=readLine().toString()
        if(actualizarR=="1"){
            //FALTA..-----
        }else if(actualizarR=="2"){
        ingresarEstudiante(Datosestudiante)
        añadir(Datosestudiante)
        read(Datosestudiante)}
    }
    if(accion == "leer"){
        read(Datosestudiante)
    }
}

