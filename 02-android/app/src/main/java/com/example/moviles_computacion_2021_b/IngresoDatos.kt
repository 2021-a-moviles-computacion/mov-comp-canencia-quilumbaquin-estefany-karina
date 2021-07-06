package com.example.moviles_computacion_2021_b

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.w3c.dom.Text

class IngresoDatos : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_datos)

        EBaseDatos.TablaUsuario = ESqliteHelperUsuario(this)


        val btnGuardar = findViewById<Button>(
            R.id.btn_guardar
        )

        val txtNombre = findViewById<EditText>(
            R.id.etxt_nombre
        )

        val txtDescripcion = findViewById<EditText>(
            R.id.etxt_descripcion
        )
        val txtid = findViewById<EditText>(
            R.id.etxt_id
        )
        btnGuardar.setOnClickListener{
            val id = txtid.text.toString().toInt()
            val nombre = txtNombre.text.toString()
            val descripcion = txtDescripcion.text.toString()

            val usuario = EUsuarioBDD(id, nombre, descripcion)
        }
    }
}