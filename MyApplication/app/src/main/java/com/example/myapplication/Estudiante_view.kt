package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Estudiante_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiante_view)

        //boton añadir estudiante
        val btnaddProfesor = findViewById<Button>(
            R.id.btn_anadirEst
        )

        btnaddProfesor.setOnClickListener{
            abrirActividad(RegistroEstudiante::class.java)
        }
    }

    fun abrirActividad(
        clase: Class<*>
    ){
        val intentExplicito = Intent(
            this,
            clase
        )
        this.startActivity(intentExplicito);
    }
}