package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Profesor_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor_view)

        //boton añadir profesor
        val btnaddProfesor = findViewById<Button>(
            R.id.btn_anadirProf
        )

        btnaddProfesor.setOnClickListener{
            abrirActividad(RegistroProfesor::class.java)
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