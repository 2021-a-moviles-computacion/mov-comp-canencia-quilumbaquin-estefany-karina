import java.io.*
import java.util.*


fun create(fileName: String, args: ArrayList<Estudiante> = arrayListOf()) {
    val i :Int
    var file = File(fileName)

    // CREAR UN NUEVA ARCHIVO
    val isNewFileCreated :Boolean = file.createNewFile()

    file.bufferedWriter().use { out ->
        profesor()
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

fun read(fileName: String) {
    var i :Int = 1

    File(fileName).readLines().forEach {
        print((i++))
        println(": "+it)
    }
}

fun update(filePath: String?, oldString: String, newString: String?) {
        val Updatefile = File(filePath)
        var DatoActual = ""
        var reader: BufferedReader? = null
        var writer: FileWriter? = null
        try {
            reader = BufferedReader(FileReader(Updatefile))

            //Lee todas las lineas del archivo
            var line = reader.readLine()
            while (line != null) {
                DatoActual = DatoActual + line + System.lineSeparator()
                line = reader.readLine()
            }

            //Remplaza el anteriguo dato por un nuevo
            val nuevoDato = DatoActual.replace(oldString.toRegex(), newString!!)

            //Reescribe el dato
            writer = FileWriter(Updatefile)
            writer.write(nuevoDato)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                //aqui se cierran los recursos
                reader!!.close()
                writer!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
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





