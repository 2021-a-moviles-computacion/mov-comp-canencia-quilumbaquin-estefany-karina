package com.example.examen2b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.examen02.R

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
    }
}