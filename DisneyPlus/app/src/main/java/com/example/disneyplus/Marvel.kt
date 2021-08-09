package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Marvel : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_marvel)

        val imgDisney: ImageView
        imgDisney=findViewById(R.id.img_marvel)
        Picasso.get().load("https://www.gannett-cdn.com/presto/2021/01/07/USAT/0d87949b-7f95-4318-a7f7-72f2b6893d05-marvel-shows.png").into(imgDisney);

        val Principales: MutableList<catergoriaItem> = ArrayList()
        Principales.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/capitana-marvel-poster-1551691489.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        Principales.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/vengadores-infinity-war-poster-1551691493.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        Principales.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/vengadores-endgame-orden-peli-culas-marvel-1556096718.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        Principales.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/vengadores-era-de-ultron-poster-1551691493.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        Principales.add(catergoriaItem(1, "https://pbs.twimg.com/media/EGs-0ryWsAMiKyq.jpg"))
        Principales.add(catergoriaItem(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGP9qkaTqKoS5fiqfVLUnNCLd-2IP055JaNxAazldoZ8pNA3x2t6ffEi4r_9rfLD6nQZ0&usqp=CAU"))

        val UniversoMarvel: MutableList<catergoriaItem> = ArrayList()
        UniversoMarvel.add(catergoriaItem(1, "https://www.alohacriticon.com/wp-content/uploads/2021/06/loki-teleserie-marvel-disney-poster-sinopsis.jpg"))
        UniversoMarvel.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/vengadores-endgame-orden-peli-culas-marvel-1556096718.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/vengadores-era-de-ultron-poster-1551691493.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1, "https://pbs.twimg.com/media/EGs-0ryWsAMiKyq.jpg"))
        UniversoMarvel.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/capitana-marvel-poster-1551691489.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/vengadores-infinity-war-poster-1551691493.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGP9qkaTqKoS5fiqfVLUnNCLd-2IP055JaNxAazldoZ8pNA3x2t6ffEi4r_9rfLD6nQZ0&usqp=CAU"))

        val faseUno: MutableList<catergoriaItem> = ArrayList()
        faseUno.add(catergoriaItem(1, "https://es.web.img3.acsta.net/medias/nmedia/18/66/64/01/20168724.jpg"))
        faseUno.add(catergoriaItem(1, "https://m.media-amazon.com/images/I/51BOoBOooAL.jpg"))
        faseUno.add(catergoriaItem(1, "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/1/1f/Iron_Man_3_Portada.png/revision/latest?cb=20191029194857&path-prefix=es"))
        faseUno.add(catergoriaItem(1, "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/6/6d/Thor_Movie_Storybook.png/revision/latest/top-crop/width/360/height/450?cb=20190110145420&path-prefix=es"))
        faseUno.add(catergoriaItem(1, "https://mk0movieguide99l7786.kinstacdn.com/wp-content/uploads/2012/08/thor-movie-poster-1020556448.jpg"))
        faseUno.add(catergoriaItem(1, "https://static.wikia.nocookie.net/ironman/images/d/da/P170620_v_v8_ba.jpg/revision/latest?cb=20191202183622"))

        val faseDos: MutableList<catergoriaItem> = ArrayList()
        faseDos.add(catergoriaItem(1, "https://es.web.img3.acsta.net/medias/nmedia/18/77/86/82/20486826.jpg"))
        faseDos.add(catergoriaItem(1, "https://i.pinimg.com/originals/fc/f6/fd/fcf6fdadf335a2f7d524ac3acf528a3a.jpg"))
        faseDos.add(catergoriaItem(1, "https://upload.wikimedia.org/wikipedia/en/7/7f/Thor_The_Dark_World_poster.jpg"))
        faseDos.add(catergoriaItem(1, "https://www.ecartelera.com/carteles/4800/4830/001_p.jpg"))
        faseDos.add(catergoriaItem(1, "https://upload.wikimedia.org/wikipedia/en/f/ff/Avengers_Age_of_Ultron_poster.jpg"))
        faseDos.add(catergoriaItem(1, "https://pbs.twimg.com/media/EGs-0ryWsAMiKyq.jpg"))

        val faseTres: MutableList<catergoriaItem> = ArrayList()
        faseTres.add(catergoriaItem(1, "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/b/bf/Captain_America_Civil_War_-_Poster_definitivo.png/revision/latest?cb=20191029195149&path-prefix=es"))
        faseTres.add(catergoriaItem(1, "https://images.moviesanywhere.com/4677177f6f0595289bc3e767e7b47459/1d6c6c73-ab1e-4453-969c-6a4e965ebb37.jpg"))
        faseTres.add(catergoriaItem(1, "https://es.web.img3.acsta.net/medias/nmedia/18/84/79/82/20099009.jpg"))
        faseTres.add(catergoriaItem(1, "https://static.wikia.nocookie.net/marveldatabase/images/1/1c/Black_Widow_%28film%29_poster_019.jpg/revision/latest?cb=20210629171105"))
        faseTres.add(catergoriaItem(1, "https://pbs.twimg.com/media/EGs-0ryWsAMiKyq.jpg"))
        faseTres.add(catergoriaItem(1, "https://i.pinimg.com/originals/82/fa/22/82fa2267ef524c4a2450af30aa2d64d3.jpg"))

        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Principales",Principales))
        categorias.add(Categorias("Universo cinematográfico de marvel",UniversoMarvel))
        categorias.add(Categorias("Universo cinematográfico de marvel: Fase uno",faseUno))
        categorias.add(Categorias("Universo cinematográfico de marvel: Fase dos",faseDos))
        categorias.add(Categorias("Universo cinematográfico de marvel: Fase tres",faseTres))

        setCategoriasRecycleView(categorias)
    }
    private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvMarvel)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }
}