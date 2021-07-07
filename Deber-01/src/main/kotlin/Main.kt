
fun main() {
    var Datosestudiante: ArrayList<Estudiante> = arrayListOf()
    var datosProfesor: Profesor
    var accion: String
    var fileName: String

    print("Ingrese una acción: \ncrear \neliminar \nactualizar(cambiar información-Añadir un nuevo registro) \nleer\n" +
            "¿Que desea hacer?:    ")
    accion = readLine().toString()


    if(accion == "crear"){
        print("\n\nIngrese el nombre del archivo:   ")
        val fileName = readLine().toString()
        ingresarEstudiante(Datosestudiante)
        create(fileName,Datosestudiante)
        read(fileName)
    }

    if(accion == "eliminar"){

        //FALTA FUNCION ELIMINAR
        print("\n\nIngrese el nombre del archivo:    ")
        fileName = readLine().toString()
        read(fileName)
        print("\nDesde de que linea desea eliminar:   ")
        var startLine :Int = readLine()?.toInt() as Int
        print("\n,Número de lineas que desea borrar:    ")
        var num :Int = readLine()?.toInt() as Int

        eliminar(fileName,startLine,num)
    }

    if(accion == "actualizar"){

        println("\n\nIngrese: \n1 para Cambiar información de un registro \n2 para Ingresar un nuevo registro")
        var actualizarR:String=readLine().toString()

        if(actualizarR=="1"){
            print("\n\nIngrese el nombre del archivo:    ")
            fileName = readLine().toString()
            read(fileName)

            print("\nDato actual: ")
            var actual= readLine().toString()
            print("\nNuevo Dato: ")
            var nuevo= readLine().toString()
            update(fileName, actual, nuevo)

        }else if(actualizarR=="2"){
            print("\n\nIngrese el nombre del archivo:    ")
            fileName = readLine().toString()

            print("Ingresar")
            ingresarEstudiante(Datosestudiante)
            añadir(fileName, Datosestudiante)
            read(fileName)}
    }

    if(accion == "leer"){
        print("\n\nIngrese el nombre del archivo:    ")
        fileName = readLine().toString()
        read(fileName)
    }
}

