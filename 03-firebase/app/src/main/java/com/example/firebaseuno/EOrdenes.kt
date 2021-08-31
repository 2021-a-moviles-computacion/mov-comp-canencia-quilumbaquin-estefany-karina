package com.example.firebaseuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EOrdenes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eordenes)
        getRestaurantesSpinner()
        getproductoSpinner()

    }

    fun getRestaurantesSpinner(){
        var spinnerRestaurante = findViewById<Spinner>(R.id.sp_restaurantes)

        var getRestaurantes: (MutableList<DocumentSnapshot>)
        var restaurantessListSpinner = ArrayList<String>()
        val dbProductos = Firebase.firestore
        val referenciaRestaurante = dbProductos.collection("restaurante")
            .get().addOnSuccessListener {
                getRestaurantes = it.documents
                getRestaurantes.forEach{ iteration ->
                    restaurantessListSpinner.add(iteration.get("nombre").toString())
                }
                val lista = restaurantessListSpinner.toList()
                Log.i("firestore - restaurante", "Restaurantes: ${lista}")
                val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista)
                spinnerRestaurante.adapter = adaptador
            }
    }

    fun getproductoSpinner (){
        var spinnerProductos = findViewById<Spinner>(R.id.sp_producto)

        var getProductos: (MutableList<DocumentSnapshot>)
        var productosListSpinner = ArrayList<String>()
        val dbProductos = Firebase.firestore
        val referenciaProducto = dbProductos.collection("producto")
            .get().addOnSuccessListener {
                getProductos = it.documents
                getProductos.forEach{ iteration ->
                    productosListSpinner.add(iteration.get("nombre").toString())
                }
                val lista = productosListSpinner.toList()
                Log.i("firestore - producto", "Productos: ${lista}")
                val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista)
                spinnerProductos.adapter = adaptador
            }
    }
}