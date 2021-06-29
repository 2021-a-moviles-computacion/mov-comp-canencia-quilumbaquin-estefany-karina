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
        val botonIrCicloVida = findViewById<Button>(
            R.id.btn_ciclo_vida)

        /*botenIrCicloVida
            .setOnClickListener {
                abrirCicloVida()*/
        botonIrCicloVida.setOnClickListener{abrirActividad(AcicloVida::class.java)}
            val botonIrListView = findViewById<Button>(
                R.id.btn_ir_list_view
            )
            botonIrListView.setOnClickListener{abrirActividad(BListView::class.java)}

            val botonIrIntent = findViewById<Button>(
                R.id.btn_ir_intent
            )
        botonIrIntent.setOnClickListener {abrirActividad(CIntentExplicitoParametros::class.java)}
    }

    fun abrirActividad(
        clase: Class <*>
    ){
        val intentExplicito= Intent( //intent es una calse, empieza con una laetra mayuscula
            this,
            //AcicloVida::class.java
        clase
        )
        startActivity(intentExplicito)
    }

    fun abrirActividadConParametros(
        clase: Class<*>
    ){
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("nombre","Karina")
        intentExplicito.putExtra("apellido","Canencia")
        intentExplicito.putExtra("edad","23")
        startActivity(intentExplicito)
    }
}