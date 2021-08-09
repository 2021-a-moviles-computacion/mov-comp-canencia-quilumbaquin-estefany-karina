package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class StarWars : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_star_wars)
        val imgDisney: ImageView
        imgDisney=findViewById(R.id.img_star)
        Picasso.get().load("https://lumiere-a.akamaihd.net/v1/images/disney_shop_landing_mobile_800x600px_f4b6a230.png").into(imgDisney);

        val Series: MutableList<catergoriaItem> = ArrayList()
        Series.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/mandalorian-poster-1567627399.jpg"))
        Series.add(catergoriaItem(1, "https://es.web.img2.acsta.net/pictures/15/11/17/13/30/119627.jpg"))
        Series.add(catergoriaItem(1, "https://static.wikia.nocookie.net/esstarwars/images/f/ff/The_Clone_Wars_film_poster.jpg/revision/latest?cb=20080828154132"))
        Series.add(catergoriaItem(1, "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2018/04/increibles.jpg?itok=vZzCSlvS"))
        Series.add(catergoriaItem(1, "https://static.wikia.nocookie.net/esstarwars/images/f/fd/BadBatchPosterLA.jpg/revision/latest?cb=20210423032309"))
        Series.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_insideout_19751_af12286c.jpeg"))
        Series.add(catergoriaItem(1, "https://pics.filmaffinity.com/Star_Wars_The_Clone_Wars_La_temporada_final_Miniserie_de_TV-429429469-large.jpg"))

        val Peliculas: MutableList<catergoriaItem> = ArrayList()
        Peliculas.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/han-solo-una-historia-de-star-wars-1575448990.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        Peliculas.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/la-amenaza-fantasma-1575448990.jpg"))
        Peliculas.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/el-ascenso-de-skywalker-1575448990.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        Peliculas.add(catergoriaItem(1, "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/el-retorno-del-jedi-1575448991.jpg"))
        Peliculas.add(catergoriaItem(1, "https://lh3.googleusercontent.com/proxy/12dabJEKGZzJSYaoXAErPEy5vUtLz4hx0XsWz60N-pc-luoq0-oQWPGunnAzN_SgWBE59gSTgQ3ucJMPiuPWU2F0VH8YeYEBkHZAhuVn6XvDt85ZOoDHzo9gSV4KQsKBgESGzuD2qFkzXyYj-byDkHtEPz28mvUJxNu6O-QBHg"))

        val cortos: MutableList<catergoriaItem> = ArrayList()
        cortos.add(catergoriaItem(1, "https://www.nocturnaediciones.com/imagenes/biblioteca/149_alta.jpg"))
        cortos.add(catergoriaItem(1, "https://es.web.img3.acsta.net/pictures/21/05/20/17/43/0503384.jpg"))
        cortos.add(catergoriaItem(1, "https://m.media-amazon.com/images/M/MV5BZmNkZTliYWYtMmEyMi00MTMxLTg4MjEtYmI0NjQxYTE0Zjc2XkEyXkFqcGdeQXVyMTE5MTkxMDI2._V1_.jpg"))
        cortos.add(catergoriaItem(1, "https://i.pinimg.com/736x/00/86/56/0086560b727e09aa2036b34682a8ea15.jpg"))
        cortos.add(catergoriaItem(1, "https://gianninabraschi.files.wordpress.com/2011/10/empireofdreamsspanish11.jpg"))

        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Series",Series))
        categorias.add(Categorias("Películas",Peliculas))
        categorias.add(Categorias("Cortos y especiales",cortos))

        setCategoriasRecycleView(categorias)
    }
    private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvStar)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }
}