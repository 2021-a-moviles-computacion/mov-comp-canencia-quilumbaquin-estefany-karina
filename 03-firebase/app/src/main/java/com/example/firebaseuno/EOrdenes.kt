package com.example.firebaseuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EOrdenes : AppCompatActivity() {

    private lateinit var spinnerRestaurante: Spinner
    private lateinit var spinnerProducto: Spinner

    var Itemseleccionado = ""
    var PrecioProducto = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_eordenes)

        val sumaTotal = findViewById<TextView>(R.id.tv_total)
        val cantidad = findViewById<EditText>(R.id.et_cantidad_producto)
        val botonAdd = findViewById<Button>(R.id.btn_anadir_lista_producto)
        spinnerRestaurante = findViewById(R.id.sp_restaurantes)
        spinnerProducto = findViewById(R.id.sp_producto)
        //val cabecera = findViewById<TextView>(R.id.txt_cabecera)
        //cabecera.text = "PRODUCTO\t\t\t\t\tCANTIDAD\t\t\tPRECIO/U\t\t\tTOTAL"


        val listproducto: MutableList<Producto> = obtenerProductoRestaurante("producto") as MutableList<Producto>
        val listrestaurante: MutableList<Restaurante> = obtenerProductoRestaurante("restaurante") as MutableList<Restaurante>
        val adaptadorProducto: ArrayAdapter<Producto> = ArrayAdapter<Producto>(this, android.R.layout.simple_spinner_item, listproducto)
        val adaptadorRestaurante: ArrayAdapter<Restaurante> = ArrayAdapter<Restaurante>(this, android.R.layout.simple_spinner_item, listrestaurante)
        listener(adaptadorProducto, spinnerProducto, "producto")
        listener(adaptadorRestaurante, spinnerRestaurante, "restaurante")
        val listViewProducto = findViewById<ListView>(R.id.lv_lista_productos)
        var totalFinal = 0.0
        val itemProductosSeleccionados = arrayListOf<String>()
        val adaptadorListView: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemProductosSeleccionados)
        listViewProducto.adapter = adaptadorListView


        //BOTON AÑADIR
        botonAdd.setOnClickListener {
            val cantidadpr = cantidad.text.toString()
            if (cantidadpr != "" && cantidadpr.toInt() > 0) {
                val totalCantidadP = cantidadpr.toInt()
                val total = PrecioProducto * totalCantidadP
                val number2digits:Double = String.format("%.2f", total).toDouble()

                val mostrarlistview =
                    "\t\t\t$Itemseleccionado\t\t\t\t\t\t\t\t\t\t\t\t\t$totalCantidadP\t\t\t\t\t\t\t\t$PrecioProducto\t\t\t\t\t\t$number2digits  "
                totalFinal += number2digits
                val numbeTotlar2digits:Double = String.format("%.2f", totalFinal).toDouble()
                sumaTotal.text = numbeTotlar2digits.toString()
                itemProductosSeleccionados.add(mostrarlistview)
                adaptadorListView.notifyDataSetChanged()
                cantidad.text.clear()
            }
        }
    }

    private fun listener(adaptador: ArrayAdapter<*>, spinner: Spinner, nombreClase: String) {
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                if (nombreClase == "producto") {
                    val itemProductoSel: Producto = parent?.getItemAtPosition(position) as Producto
                    Itemseleccionado = itemProductoSel.nombre!!
                    PrecioProducto = itemProductoSel.precio!!
                } else {
                    val itemRestauranteSel: Restaurante = parent?.getItemAtPosition(position) as Restaurante
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Log.i("firebase-firestore", "Item no seleccionado")
            }
        }
    }

    private fun obtenerProductoRestaurante(coleccion: String): MutableList<*> {
        val ListaProducto = mutableListOf<Producto>()
        val listaRestaurante = mutableListOf<Restaurante>()
        val db = Firebase.firestore
        val referencia = db.collection(coleccion)
        return when (coleccion) {
            "producto" -> {
                referencia.get().addOnSuccessListener { documents ->
                    for (document in documents) {
                        val producto = document.toObject(Producto::class.java)
                        ListaProducto.add(producto)
                    }
                }.addOnFailureListener {
                    Log.i("firebase-firestore", "Colección no encontrada")
                }
                ListaProducto.add(Producto("", 0.00))
                ListaProducto

            }
            else -> {
                referencia.get().addOnSuccessListener { documents ->
                    for (document in documents) {
                        val restaurante = document.toObject(Restaurante::class.java)
                        listaRestaurante.add(restaurante)
                    }
                }.addOnFailureListener {
                    Log.i("firebase-firestore", "colección no encontrada")
                }
                listaRestaurante.add(Restaurante(""))
                listaRestaurante
            }
        }
    }
}