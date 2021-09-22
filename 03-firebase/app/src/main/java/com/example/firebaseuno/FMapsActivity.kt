package com.example.firebaseuno

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.type.LatLng

class FMapsActivity : AppCompatActivity() {

    private lateinit var mapa: GoogleMap
    var permisos = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fmaps)
        solicitarPermisos()
        val fragmenttoMapa = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        fragmenttoMapa.getMapAsync{ googleMap ->
            if(googleMap != null){
                mapa = googleMap
                establecerConfiguracionMapa()
                val quicentro = LatLng(-0.176125, -78.480208)
                val titulo = "Quicentro"
                val zoom = 17f
                añadirMarcador(quicentro, titulo)
                moverCamaraConZoom(quicentro,zoom)
                escucharListener()

                val poliLineUno = googleMap
                    .addPolyline(
                        PolylineOptions()
                            . clickable(true).add(
                                LatLng(-0.1771546902239471, -78.48344981495214),
                                LatLng(-0.17968981486125768, -78.48269198043828),
                                LatLng(-0.17710958124147777, -78.48142892291516)
                            )
                    )
            }
        }

        val botonIrCarolina = findViewById<Button>(R.id.btn_ir_carolina)
        botonIrCarolina.setOnClickListener {
            val carolina = LatLng (-0.18288452555103193, -78.48449971346241)
            val zoom = 17f
            moverCamaraConZoom(carolina, zoom)

        }

    }

    private fun moverCamaraConZoom(latLng: LatLng, zoom: Float = 18f) {
        mapa.moveCamera(
            CameraUpdateFactory.newLatLngZoom(latLng, zoom)
        )
    }

    private fun añadirMarcador(latLng: LatLng, title: String) {
        mapa.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(title)
        )
    }

    fun escucharListener(){
        mapa.setOnPolygonClickListener {
            Log.i("mapa", "setOnPolygonClickListener ${it}")
        }
        mapa.setOnPolylineClickListener {
            Log.i("mapa", "setOnPolyLineClickListener ${it}")
        }
        mapa.setOnMarkerClickListener {
            Log.i("mapa", "setOnMarkerClickListener ${it}")
            return@setOnMarkerClickListener true
        }
        mapa.setOnCameraMoveListener {
            Log.i("mapa", "setOnCameraMoveListener")
        }
        mapa.setOnCameraMoveStartedListener {
            Log.i("mapa", "setOnCameraMoveListener ${it}")
        }
        mapa.setOnCameraIdleListener {
            Log.i("mapa", "setOnCameraIdleListener")
        }
    }

    fun solicitarPermisos(){
        val contexto = this.applicationContext
        val permisosFineLocation = ContextCompat
            .checkSelfPermission(
                contexto,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            val tienePermisos =  permisosFineLocation == PackageManager.PERMISSION_GRANTED
        if(tienePermisos){
            permisos = true
        }else{
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1
            )
        }
    }

    fun establecerConfiguracionMapa(){
     val contexto = this.applicationContext
     with(mapa)   {
         val permisosFineLocation = ContextCompat.checkSelfPermission(
             contexto,
             android.Manifest.permission.ACCESS_FINE_LOCATION
         )
         val tienePermisos =  permisosFineLocation == PackageManager.PERMISSION_GRANTED
         if(tienePermisos){
             mapa.isMyLocationEnabled = true //no tenemos permisos aun
         }
         uiSettings.isZoomControlsEnabled = true
         uiSettings.isMyLocationButtonEnabled = true //no tenemos permisos aun
     }
    }
}