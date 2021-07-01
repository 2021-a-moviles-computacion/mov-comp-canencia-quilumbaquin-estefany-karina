import com.sun.jdi.BooleanType
import java.text.DateFormat
import java.util.*

class Estudiante(
    var Nombre: String,
    var Edad: Int,
    var segunda: Boolean,
    var calificacion: Double,
    var fechaIngreso: Date = Date()
        ) {
}