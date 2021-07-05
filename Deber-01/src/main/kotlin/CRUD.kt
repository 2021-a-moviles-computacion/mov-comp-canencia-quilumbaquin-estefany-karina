import java.io.File


fun create(args: ArrayList<Estudiante> = arrayListOf()) {

    val fileName = "data.txt"
    val i :Int
    var file = File(fileName)

    // CREAR UN NUEVA ARCHIVO
    val isNewFileCreated :Boolean = file.createNewFile()

    file.bufferedWriter().use { out ->
        for(i in args.indices){
        out.write(args[i].Nombre+"      "+ args[i].Edad +"     "+ args[i].segunda +
                "     "+args[i].calificacion +"     "+ args[i].fechaRegistro+"\n")
        }}

    if(isNewFileCreated){
        println("$fileName Se ha creado.")
    } else{
        println("$fileName ya existe.")
    }

    // TRATAR DE CREAR UN NUEVO ARCHIVO Q YA EXISTE
    val isFileCreated :Boolean = file.createNewFile()

    if(isFileCreated){
        println("$fileName se ha creado.")
    } else{
        println("$fileName ya existe.")
    }

}

fun read(args: ArrayList<Estudiante> = arrayListOf()) {
    val fileName :String = "data.txt"
    var i :Int = 1

    File(fileName).readLines().forEach {
        print((i++))
        println(": "+it)
    }
}

fun update(args: ArrayList<Estudiante> = arrayListOf()) {
    var lineNumber = 0
    var newString =""
    var new :String
    var i :Int

    print("ingresar id:  ")
    i = readLine()?.toInt() as Int

    print("Nombre: ")
    new= readLine().toString()

    File("data.txt").forEachLine {
        ++lineNumber
        println("$lineNumber: $it")
        newString = args[i].Nombre.replace(args[i].Nombre, new)
        println("New string : $newString")
    }
    File("data.txt").writeText(newString)
}

fun añadir(args: ArrayList<Estudiante> = arrayListOf()) {
    for(i in args.indices){
    File("data.txt").appendText(args[i].Nombre+"      "+ args[i].Edad +"     "+ args[i].segunda +
            "     "+args[i].calificacion +"     "+ args[i].fechaRegistro+"\n")}
}



