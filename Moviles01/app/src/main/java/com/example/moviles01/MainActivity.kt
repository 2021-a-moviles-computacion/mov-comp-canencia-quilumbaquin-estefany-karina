package com.example.moviles01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this.findViewbyId()..Clase
        val botenIrCicloVida = findViewById<Button>(
            R.id.btn_ciclo_vida
        )
        botenIrCicloVida
            .setOnClickListener {
                abrirCicloVida()
            }
    }

    fun abrirCicloVida(){
        val intentExplicito= Intent( //intent es una calse, empieza con una laetra mayuscula
            this,
            AcicloVida::class.java
        )
        startActivity(intentExplicito)
    }
}