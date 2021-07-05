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
    var newString = ""
    File("data.txt").forEachLine {
        ++lineNumber
        println("$lineNumber: $it")
        newString = args[0].Nombre.replace(args[0].Nombre, "NN")
        println("New string : $newString")
    }
    File("data.txt").writeText(newString)
}

fun añadir(args: ArrayList<Estudiante> = arrayListOf()) {
    for(i in args.indices){
    File("data.txt").appendText("\n"+args[i].Nombre+"      "+ args[i].Edad +"     "+ args[i].segunda +
            "     "+args[i].calificacion +"     "+ args[i].fechaRegistro)}
}

fun eliminar(fileName: String, startLine: Int, numLines: Int) {
    require(!fileName.isEmpty() && startLine >= 1 && numLines >= 1)
    val f = File(fileName)
    if (!f.exists()) {
        println("$fileName no existe")
        return
    }
    var lines = f.readLines()
    val size = lines.size
    if (startLine > size) {
        println("La línea de salida está más allá de la longitud del archivo")
        return
    }
    var n = numLines
    if (startLine + numLines - 1 > size) {
        println("Intentando eliminar algunas líneas que están más allá del final del archivo")
        n = size - startLine + 1
    }
    lines = lines.take(startLine - 1) + lines.drop(startLine + n - 1)
    val text = lines.joinToString(System.lineSeparator())
    f.writeText(text)
}




