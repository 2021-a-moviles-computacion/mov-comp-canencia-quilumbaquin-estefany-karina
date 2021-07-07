package com.example.moviles_computacion_2021_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class Usuario : AppCompatActivity() {
    private lateinit var edNombre: EditText
    private lateinit var edDescripcion: EditText
    private lateinit var btnAdd:Button
    private lateinit var btnVer:Button

    private lateinit var sqliteHelper: ESqliteHelperUsuario
    private lateinit var recyclerView: RecyclerView
    private var adaptador: UsuarioAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        ver()
        initRecycleView()
        sqliteHelper = ESqliteHelperUsuario(this)

        btnAdd.setOnClickListener{añadirUsuario()}
        btnVer.setOnClickListener{obtenerUsuario()}
    }

    fun obtenerUsuario(){
        val lista=sqliteHelper.consultarTodos()
        Log.e("Consultar Usuario", "${lista.size}")
        adaptador?.addItems(lista)
    }

    private fun añadirUsuario(){
        val nombre = edNombre.text.toString()
        val descripcion = edDescripcion.text.toString()
        val id = Random().nextInt(100)

        if(nombre.isEmpty() || descripcion.isEmpty()){
            Toast.makeText(this,"ingrese el requerimiento", Toast.LENGTH_SHORT).show()
        }else{
            //val std= EUsuarioBDD(id,nombre, descripcion)
                //REVISAR************************
            val estado = sqliteHelper.crearUsuarioFormulario(nombre, descripcion)

            if (estado != null){
                Toast.makeText(this,"usuario añadido", Toast.LENGTH_SHORT).show()
                borrarTexto()
                Log.e("añadir","${nombre}")
            }else{
                Toast.makeText(this,"usuario no añadido", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun borrarTexto(){
        edNombre.setText("")
        edDescripcion.setText("")
        edNombre.requestFocus()
    }

    fun initRecycleView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adaptador = UsuarioAdapter()
        recyclerView.adapter = adaptador
    }

    private fun ver(){
        edNombre = findViewById(R.id.edNombre)
        edDescripcion = findViewById(R.id.edDescripcion)
        btnAdd=findViewById(R.id.btn_add)
        btnVer=findViewById(R.id.btn_ver)
        recyclerView = findViewById(R.id.recycleView)
    }
}