package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button

class Estudiante : AppCompatActivity() {
    companion object{
        var arregloEst = ArrayList<BEstudiante>()
    }
    var adapter: ArrayAdapter<BEstudiante>? = null
    var CODIGO_RESPUESTA_INTENT_EXPLICITO = 402
    var CODIGO_RESPUESTA_INTENT_EXPLICITO3 = 405
    var posicionItem = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiante)
        val btn_añadir = findViewById<Button>(R.id.btnAnadirEstudiante)
        btn_añadir.setOnClickListener {
            abrirActividad(AnadirEstudiante::class.java)
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