package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AnadirEstudiante : AppCompatActivity() {
    lateinit var  firebaseDatabase: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    private lateinit var fechaRegistro: EditText

    companion object{
        var nombreEst = ""
    }
    //var arregloUbicaciones = ArrayList<ubicacion>()
    //var ubicacionSeleccionado: ubicacion? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var  firebaseDatabase: FirebaseDatabase
        lateinit var databaseReference: DatabaseReference

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_estudiante)
        val nombreEstudiante = findViewById<EditText>(R.id.txtNombreEstudiante)
        val edadEstudiante = findViewById<EditText>(R.id.txtEdadEstudiante)//validado
        val matricula = findViewById<EditText>(R.id.txtMatricula) //validado true o false
        val calificacion = findViewById<EditText>(R.id.txtCalificacion) //validado
        val botoneditar = findViewById<Button>(R.id.btnAnadirEst)
        val id_P = Profesor.idProf //ESte es el id del profesor q ya existe
        var altitud = findViewById<EditText>(R.id.et_altitud)
        var latitud = findViewById<EditText>(R.id.et_latitud)

        fechaRegistro = findViewById(R.id.txtFecha)
        fechaRegistro.setOnClickListener{ShowDatePickerDialog()}

        inicializarFirebase()

        botoneditar.setOnClickListener {
            if(nombreEstudiante.text.isNotBlank() && matricula.text.isNotBlank() && edadEstudiante.text.isNotBlank()
                &&calificacion.text.isNotBlank() && calificacion.text.isNotBlank() && altitud.text.isNotBlank()
                &&latitud.text.isNotBlank()){
                    if(validarNombre(nombreEstudiante.text.toString())){
                        if(validarEdad(edadEstudiante.text.toString())){
                            if(validarMatricula(matricula.text.toString())){
            val nombre = nombreEstudiante.text.toString()
            val edadEst = edadEstudiante.text.toString().toInt()
            val matriiculaEst = matricula.text.toString()
            val fecha = fechaRegistro.text.toString()
            val calificacionEst = calificacion.text.toString().toDouble()
            val altitudEs = altitud.text.toString().toDouble()
            val latitudEs = latitud.text.toString().toDouble()

            val nuevoEstudiante = hashMapOf<String, Any>(
                "nombre" to nombre,
                "edad" to edadEst,
                "matricula" to matriiculaEst,
                "fecha" to fecha,
                "calificacion" to calificacionEst,
                "altitud" to altitudEs,
                "latitud" to latitudEs,

                )
            val db = Firebase.firestore
            val referencia = db.collection("profesor").document(id_P).collection("estudiante")
                .document("${nombreEstudiante.text}")
            referencia.set(nuevoEstudiante).addOnSuccessListener {
                nombreEstudiante.text.clear()
                edadEstudiante.text.clear()
                matricula.text.clear()
                fechaRegistro.text.clear()
                calificacion.text.clear()
                latitud.text.clear()
                altitud.text.clear()
                Toast.makeText(this,"Estudiante registrado con éxito", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {}
                Toast.makeText(this,"Estudiante registrado exitosamente", Toast.LENGTH_SHORT).show()
                abrirActividad(Estudiante::class.java)
                            }else{
                                Toast.makeText(this,"La matrícula solo acepta true o false", Toast.LENGTH_LONG).show()
                            }
                        }else{
                            Toast.makeText(this,"La edad ingresada es incorrecto", Toast.LENGTH_SHORT).show()
                        }
                }else{
                        Toast.makeText(this,"El nombre ingresado es incorrecto", Toast.LENGTH_SHORT).show()
                    }
            }else{
                Toast.makeText(this,"Llene todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun validarEdad(texto: String):Boolean{
        val validar = Regex("^[0-9]{2}$")
        return validar.matches(texto)
    }
    fun validarMatricula(texto: String):Boolean{
        val validar = Regex("^False|false|FALSE|True|true|TRUE$")
        return validar.matches(texto)
    }
   fun validarNombre(texto: String):Boolean{
       val validar = Regex("^[a-zA-Z ]{3,30}\$")
       return validar.matches(texto)
   }

    fun ShowDatePickerDialog() {
        val datePicker = DatePickerFragment{day, month, year -> OnDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePcker")
    }

    fun OnDateSelected(day:Int, month:Int, year:Int){
        fechaRegistro.setText("${day}/${month}/${year}")
    }
    fun inicializarFirebase() {
        FirebaseApp.initializeApp(this)
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference()
    }

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }

}