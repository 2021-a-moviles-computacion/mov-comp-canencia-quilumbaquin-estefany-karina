package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class OpcionPixar : AppCompatActivity() {

    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_opcion_pixar)

        val imgDisney: ImageView
        imgDisney=findViewById(R.id.img_pixar)
        Picasso.get().load("https://tentulogo.com/wp-content/uploads/2018/07/pixar-logo.jpg").into(imgDisney);

        val Originales: MutableList<catergoriaItem> = ArrayList()
        Originales.add(catergoriaItem(1, "https://static.wikia.nocookie.net/disney/images/c/cc/22_vs_Earth_poster.jpg/revision/latest?cb=20210516170730&path-prefix=es"))
        Originales.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/image_5e27f8d3.jpeg?region=0,0,648,972"))
        Originales.add(catergoriaItem(1, "https://www.disneylapresspack.com/storage/programs/1624997076_MAW_S1_27x40_ACT43096_LOC_LAS.jpg"))
        Originales.add(catergoriaItem(1, "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2018/04/increibles.jpg?itok=vZzCSlvS"))
        Originales.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/image_bf8739ba.jpeg?region=0,0,540,810"))
        Originales.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_insideout_19751_af12286c.jpeg"))
        Originales.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_thegooddinosaur_19753_03c2af0a.jpeg"))



        val Películas: MutableList<catergoriaItem> = ArrayList()
        Películas.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_insideout_19751_af12286c.jpeg"))
        Películas.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_thegooddinosaur_19753_03c2af0a.jpeg"))
        Películas.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/image_2ff75a5c.jpeg?region=0%2C0%2C540%2C810"))
        Películas.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/536x0w_5c949447.png?region=0%2C0%2C536%2C804"))
        Películas.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/image_e4eb6886.jpeg?region=0,0,540,810&width=480"))
        Películas.add(catergoriaItem(1, "https://upload.wikimedia.org/wikipedia/en/9/96/Brave_Poster.jpg"))
        Películas.add(catergoriaItem(1, "https://upload.wikimedia.org/wikipedia/en/0/02/22_vs._Earth_poster.png"))

        val Bestias: MutableList<catergoriaItem> = ArrayList()
        Bestias.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_monstersatwork_21018_ef298937.jpeg"))
        Bestias.add(catergoriaItem(1, "https://static.wikia.nocookie.net/disney/images/a/a8/Monstruos_sa.jpg/revision/latest?cb=20110804055254&path-prefix=es"))
        Bestias.add(catergoriaItem(1, "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/34234207b87f68f1d1742ae236d5496f6706f97ebb61b467ac86522e597ca005._RI_V_TTW_.jpg"))
        Bestias.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_thegooddinosaur_19753_03c2af0a.jpeg"))
        Bestias.add(catergoriaItem(1, "https://static.wikia.nocookie.net/disney/images/a/a6/Turning_Red_teaser_poster.jpg/revision/latest?cb=20210721005559&path-prefix=es"))
        Bestias.add(catergoriaItem(1, "https://educayaprende.com/wp-content/uploads/2014/05/ratatouille-cover-caratula-dvd-disney-pixar.jpg"))

        val Cortos: MutableList<catergoriaItem> = ArrayList()
        Cortos.add(catergoriaItem(1, "https://static.wikia.nocookie.net/disney/images/b/bb/Dug_mission1.jpg/revision/latest?cb=20161025232026&path-prefix=es"))
        Cortos.add(catergoriaItem(1, "https://upload.wikimedia.org/wikipedia/en/0/02/22_vs._Earth_poster.png"))
        Cortos.add(catergoriaItem(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCR6-wscCbDROVMWGMH3oIsL8GwcTcT2K9E4F8xG3fRBdcQDn1Xfb0Hm1OmOXb8kVvltM&usqp=CAU"))
        Cortos.add(catergoriaItem(1, "https://hbimg.huabanimg.com/2630faf510d31c8d26ab9d2b9e05bd617790f0526944-Z22EPz"))
        Cortos.add(catergoriaItem(1, "https://static.wikia.nocookie.net/disney/images/4/4d/5f58f644b4f7f00d1df32f07469.jpg/revision/latest?cb=20161025054213&path-prefix=es"))
        Cortos.add(catergoriaItem(1, "https://static.wikia.nocookie.net/disney/images/3/3a/Kitbull_poster.jpg/revision/latest?cb=20190216023900&path-prefix=es"))
        Cortos.add(catergoriaItem(1, "https://static.wikia.nocookie.net/doblaje/images/2/2a/Jack_jack.jpg/revision/latest?cb=20190125223415&path-prefix=es"))

        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Originales",Originales))
        categorias.add(Categorias("Películas",Películas))
        categorias.add(Categorias("Bestias y Mounstruos",Bestias))
        categorias.add(Categorias("Cortos",Cortos))

        setCategoriasRecycleView(categorias)
    }

    private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvPixar)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }
}