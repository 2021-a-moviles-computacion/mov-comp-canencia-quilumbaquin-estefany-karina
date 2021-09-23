package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ActualizarProfesor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_profesor)

        var profesorEst = intent.getSerializableExtra("profesor") as BProfesor
        val editarNombre = findViewById<EditText>(R.id.txtEditarNombreProfesor)
        val editarMateria = findViewById<EditText>(R.id.txtEditarMateria)
        val editarEdad = findViewById<EditText>(R.id.txtEditarEdad)
        val editarEstadoCivil = findViewById<EditText>(R.id.txtEditarEstado)
        val editarTelefono = findViewById<EditText>(R.id.txtEditarTelefono)
        val editar = findViewById<Button>(R.id.btn_editar)

        // obtener para editar editar valores
        editarNombre.setText(profesorEst.nombreProfesor)
        editarMateria.setText(profesorEst.materia)
        editarEdad.setText(profesorEst.edadProfesor.toString())
        editarEstadoCivil.setText(profesorEst.estadoCivil)
        editarTelefono.setText(profesorEst.telefono)

        editar.setOnClickListener {
            val nombre = editarNombre.text.toString()
            val materiaP = editarMateria.text.toString()
            val edadProfesor1 = editarEdad.text.toString()
            val EstadoCivil = editarEstadoCivil.text.toString()
            val telefono1 = editarTelefono.text.toString()

            val nuevoProfesor = hashMapOf<String, Any>(
                "nombre" to nombre,
                "materia" to materiaP,
                "edad" to edadProfesor1,
                "estadoCivil" to EstadoCivil,
                "telefono" to telefono1,
            )

            val db = Firebase.firestore
            val referencia = db.collection("Profesor").document("${editarNombre.text}")
            referencia.set(nuevoProfesor).addOnSuccessListener {
                editarNombre.text.clear()
                editarMateria.text.clear()
                editarEdad.text.clear()
                editarEstadoCivil.text.clear()
                editarTelefono.text.clear()

            }.addOnFailureListener {

            }

            abrirActividad(Profesor::class.java)
        }
}
fun abrirActividad(clase: Class<*>){
    val intentExplicito = Intent(
        this,
        clase
    )
    startActivity(intentExplicito)
}
}