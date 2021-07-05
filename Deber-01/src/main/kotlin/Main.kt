
fun main() {
    var Datosestudiante: ArrayList<Estudiante> = arrayListOf()
    var datosProfesor: Profesor
    var accion: String

    print("Ingrese una acción: \ncrear \neliminar \nactualizar(cambiar información-Añadir un nuevo registro) \nleer" +
            "¿Que desea hacer?:    ")
    accion = readLine().toString()


    if(accion == "crear"){
        ingresarEstudiante(Datosestudiante)
        create(Datosestudiante)
        read(Datosestudiante)
    }

    if(accion == "eliminar"){

        //FALTA FUNCION ELIMINAR
        print("\n\nNombre del archivo:  data.txt\n ")
        var file :String ="data.txt"
        read(Datosestudiante)
        print("\nDesde de que linea desea eliminar:   ")
        var startLine :Int = readLine()?.toInt() as Int
        print("\n,Número de lineas que desea borrar:    ")
        var num :Int = readLine()?.toInt() as Int

        eliminar(file,startLine,num)
    }

    if(accion == "actualizar"){

        println("Ingrese: 1\n para Cambiar información de un registro \n2 para Ingresar un nuevo registro")
        var actualizarR:String=readLine().toString()
        if(actualizarR=="1"){
            //FALTA..-----
            update(Datosestudiante)

        }else if(actualizarR=="2"){
        ingresarEstudiante(Datosestudiante)
        añadir(Datosestudiante)
        read(Datosestudiante)}
    }

    if(accion == "leer"){
        read(Datosestudiante)
    }
}

