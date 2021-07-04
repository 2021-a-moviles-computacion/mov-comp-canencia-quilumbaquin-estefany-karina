import java.io.File


fun create(args: ArrayList<Estudiante> = arrayListOf()) {

    val fileName = "data.txt"

    var file = File(fileName)

    // CREAR UN NUEVA ARCHIVO
    val isNewFileCreated :Boolean = file.createNewFile()

    file.bufferedWriter().use { out ->
        for(i in args.indices){
        out.write(args[i].Nombre+"      "+ args[i].Edad +"     "+ args[i].segunda +
                "     "+args[i].calificacion +"     "+ args[i].fechaIngreso+"\n")
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


/*fun read(args: ArrayList<Estudiante> = arrayListOf()) {
    val file = File("data.txt")
    var content:String = file.readText()
    println(content)
}*/

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
        newString = it.replace("JJ", "NN")
        println("New string : $newString")
    }
    File("data.txt").writeText(newString)
}

/*fun update(args: ArrayList<Estudiante> = arrayListOf()){
    val nombre: String
    val i: Int = 1
    val fileName :String = "data.txt"

    println("Ingrese el nombre:  ")
    nombre= readLine().toString()

    File(fileName).readLines().forEach{
    while(nombre.equals(args[i].Nombre,false)){
        i+1
    }
        println(nombre + "\n${i}:   "+args[i].Nombre)
}}*/



