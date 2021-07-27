package com.example.examen_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.BaseDatos
import com.example.myapplication.SQLiteHelper

class AnadirEstudiante : AppCompatActivity(), View.OnClickListener {
    private lateinit var fechaRegistro: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_estudiante)

        BaseDatos.BaseDatosSQLiteHelper = SQLiteHelper(this)
        val nombreEstudiante = findViewById<EditText>(R.id.txtNombreEstudiante)
        val edadEstudiante = findViewById<EditText>(R.id.txtEdadEstudiante)
        val matricula = findViewById<EditText>(R.id.txtMatricula)
        val calificacion = findViewById<EditText>(R.id.txtCalificacion)
        val botoneditar = findViewById<Button>(R.id.btnAnadirEst)
        val id_P = Profesor.idProf //ESte es el id del profesor q ya existe
        fechaRegistro = findViewById<EditText>(R.id.txtFecha)

        fechaRegistro.setOnClickListener{ShowDatePickerDialog()}

        botoneditar.setOnClickListener {
            val nombre = nombreEstudiante.text.toString()
            val edadEst = edadEstudiante.text.toString().toInt()
            val matriiculaEst = matricula.text.toString()
            val fecha = fechaRegistro.text.toString()
            val calificacionEst = calificacion.text.toString().toDouble()

            if (nombre.isEmpty() || matriiculaEst.isEmpty()) {
                Toast.makeText(this, "Existen campos vacios o datos incorrectos", Toast.LENGTH_LONG).show()
            } else {
                val estado = BaseDatos.BaseDatosSQLiteHelper!!.crearEstudiante(
                    id_P,//le pongo como dato el ide del profesor para q se guarde como dato
                    nombre,
                    edadEst,
                    matriiculaEst,
                    fecha,
                    calificacionEst
                )
                nombreEstudiante.setText("")
                edadEstudiante.setText("")
                matricula.setText("")
                fechaRegistro.setText("")
                calificacion.setText("")

                if (estado != null) {
                    Toast.makeText(this, "Estudiante añadido", Toast.LENGTH_LONG).show()
                    Log.i("añadir Estudiante", "profesor: ${id_P} --> Estudiante: ${nombre} ---> ${fecha}")
                } else {
                    Toast.makeText(this, "usuario no añadido", Toast.LENGTH_LONG).show()

                }
            }
        }

    }

    fun ShowDatePickerDialog() {
        val datePicker = DatePickerFragment{day, month, year -> OnDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePcker")
    }

    fun OnDateSelected(day:Int, month:Int, year:Int){
        fechaRegistro.setText("${day}/${month}/${year}")
    }
    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}



