package com.example.moviles_computacion_2021_b

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class Usuario : AppCompatActivity() {
    private lateinit var edNombre: EditText
    private lateinit var edDescripcion: EditText
    private lateinit var edId: EditText
    private lateinit var btnAdd:Button
    private lateinit var btnVer:Button
    private lateinit var btnBorrar :Button
    private lateinit var btnEditar :Button

    private lateinit var sqliteHelper: ESqliteHelperUsuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        ver()
        sqliteHelper = ESqliteHelperUsuario(this)

        btnAdd.setOnClickListener{añadirUsuario()}
        btnVer.setOnClickListener{obtenerUsuario()}
        btnBorrar.setOnClickListener{
            AlertDialog.Builder(this).apply {
                setTitle("Alerta")
                setMessage("¿Desea eliminar?")
                setPositiveButton("Si"){ _:DialogInterface, _: Int ->
                    eliminarUsuario()
                }
                setNegativeButton("No", null)
            }.show()
            }
        btnEditar.setOnClickListener{  editarUsuario() }
    }
    fun eliminarUsuario(){
        val id = edId.getText().toString().toInt()
        val mensaje = sqliteHelper.eliminarUsuarioFormulario(id)
        Toast.makeText(this,"usuario eliminado", Toast.LENGTH_SHORT).show()

    }

    fun editarUsuario(){

        val id = edId as Int
        val nombre = edNombre.text.toString()
        val descripcion = edDescripcion.text.toString()
        sqliteHelper.actualizarUsuarioFormulario(nombre,descripcion,id)


    }

    fun obtenerUsuario(){
        val id = edId.getText().toString().toInt()
        val lista=sqliteHelper.consultarUsuarioPorId(id)
        edNombre.setText(lista.nombre)
        edDescripcion.setText(lista.descripcion)
        Log.e("Consultar Usuario", "${id}")
        edId.setText("")

    }

    private fun añadirUsuario(){
        val nombre = edNombre.text.toString()
        val descripcion = edDescripcion.text.toString()
        //val id = Random().nextInt(100)

        if(nombre.isEmpty() || descripcion.isEmpty()){
            Toast.makeText(this,"ingrese el requerimiento", Toast.LENGTH_SHORT).show()
        }else{
            //val std= EUsuarioBDD(id,nombre, descripcion)
                //REVISAR************************
            val estado = sqliteHelper.crearUsuarioFormulario(nombre, descripcion)

            if (estado != null){
                Toast.makeText(this,"usuario añadido", Toast.LENGTH_SHORT).show()
                borrarTexto()
                Log.e("añadir","${nombre} ---> ${descripcion}")
            }else{
                Toast.makeText(this,"usuario no añadido", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun borrarTexto(){
        edNombre.setText("")
        edDescripcion.setText("")
        edId.setText("")
        edNombre.requestFocus()
    }

    private fun ver(){
        edNombre = findViewById(R.id.edNombre)
        edDescripcion = findViewById(R.id.edDescripcion)
        edId = findViewById(R.id.edId)
        btnAdd=findViewById(R.id.btn_add)
        btnVer=findViewById(R.id.btn_ver)
        btnBorrar=findViewById(R.id.btn_Borrar)
        btnEditar=findViewById(R.id.btn_editar)
    }
}