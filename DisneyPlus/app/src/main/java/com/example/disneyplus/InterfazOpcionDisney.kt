package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class InterfazOpcionDisney : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_interfaz_opcion_disney)
        val imgDisney: ImageView
        imgDisney=findViewById(R.id.img_disney)
        Picasso.get().load("https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/peliculas-para-ninos-cine-infantil/la-transformacion-del-logo-de-disney-en-30-anos/22.aviones-20132/47753026-1-esl-ES/22.Aviones-2013.jpg?resize=980:*").into(imgDisney);
        val Originales: MutableList<catergoriaItem> = ArrayList()
        Originales.add(catergoriaItem(1,"https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/peliculas/piratas-del-caribe-la-venganza-de-salazar/119544770-3-esl-ES/Piratas-del-Caribe-La-venganza-de-Salazar.jpg?resize=320:*"))
        Originales.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/image_9e35a739.jpeg?region=0%2C0%2C540%2C810"))
        Originales.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/20/03/20/15/13/0225217.jpg"))
        Originales.add(catergoriaItem(1,"https://www.ecartelera.com/carteles/12500/12573/004_m.jpg"))
        Originales.add(catergoriaItem(1,"https://static.wikia.nocookie.net/frozen/images/7/72/Frozen_Fever_PosterHD.png/revision/latest?cb=20150311021826&path-prefix=es"))
        Originales.add(catergoriaItem(1, "https://www.disneylapresspack.com/storage/programs/1624997076_MAW_S1_27x40_ACT43096_LOC_LAS.jpg"))
        Originales.add(catergoriaItem(1,"https://images-na.ssl-images-amazon.com/images/I/71zzK7+mLUL.jpg"))
        Originales.add(catergoriaItem(1,"https://arc-anglerfish-arc2-prod-infobae.s3.amazonaws.com/public/ECO2YTA6SBA2JCVMV3X7S4KONE.jpg"))
        Originales.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/14/03/11/09/33/450247.jpg"))
        Originales.add(catergoriaItem(1,"https://i.pinimg.com/originals/9d/71/15/9d711579b2fb48b56e2436dfed8974e5.jpg"))

        val InspiradosParquesDisney: MutableList<catergoriaItem> = ArrayList()
        InspiradosParquesDisney.add(catergoriaItem(1,"https://static.wikia.nocookie.net/descendientes-disney/images/1/19/Descendientes_2_p%C3%B3ster.jpg/revision/latest?cb=20200728065054&path-prefix=es"))
        InspiradosParquesDisney.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/16/02/15/14/51/400512.jpg"))
        InspiradosParquesDisney.add(catergoriaItem(1,"https://es.web.img2.acsta.net/pictures/14/11/25/12/32/329196.jpg"))
        InspiradosParquesDisney.add(catergoriaItem(1,"https://www.planetadelibros.com.ec/usuaris/libros/fotos/261/m_libros/260914_portada_la-bella-y-la-bestia-el-libro-de-la-pelicula_disney_201704121648.jpg"))
        InspiradosParquesDisney.add(catergoriaItem(1,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5nX1XqSnq9J_QB-1jCfy21h9QsySH6R_2y32eLrGtSr2qJotupGkhhybYVZm2w-FvXuw&usqp=CAU"))
        InspiradosParquesDisney.add(catergoriaItem(1,"https://seriesflix.nu/wp-content/uploads/2021/07/behind-the-attraction-81527-poster-683x1024.jpg"))
        InspiradosParquesDisney.add(catergoriaItem(1,"https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/peliculas/piratas-del-caribe-la-venganza-de-salazar/119544770-3-esl-ES/Piratas-del-Caribe-La-venganza-de-Salazar.jpg?resize=320:*"))
        InspiradosParquesDisney.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/19/05/08/16/59/2526525.jpg"))
        InspiradosParquesDisney.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/19/01/22/16/26/2486964.jpg"))
        InspiradosParquesDisney.add(catergoriaItem(1,"https://es.web.img3.acsta.net/medias/nmedia/18/70/33/62/20122901.jpg"))

        val waltDisney: MutableList<catergoriaItem> = ArrayList()
        waltDisney.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/image_b0c700c3.jpeg?region=0%2C0%2C540%2C810"))
        waltDisney.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/encantada-1548255368.jpg"))
        waltDisney.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/peter-pan-1548255593.jpg?resize=320:*"))
        waltDisney.add(catergoriaItem(1,"https://www.bolsamania.com/cine/wp-content/uploads/2016/12/66-400x600.jpg"))
        waltDisney.add(catergoriaItem(1,"https://www.geocities.ws/disneyanimacion/pocahontas/pocah_vhs_1a_ed.jpg"))
        waltDisney.add(catergoriaItem(1,"https://lh3.googleusercontent.com/proxy/XRwGHz4DM4jkP4VvehfHnmgEwgcAZ2efBSzdNxps5c0eoS6X0L1LaIkrulUfGIzcaNMY7aTR9vw1exCsg6MxZyUg1SsCv8mO61iEa664zbiyZc6JNw7kJmCSx_Vn16zCwO5Erh8uE8q2Hn7ApclVKDRTBIZW"))
        waltDisney.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/princess-and-the-frog-xlg-1557311159.jpg"))
        waltDisney.add(catergoriaItem(1,"https://i1.whakoom.com/large/06/11/ab1e01bd0b31471bafa0d2ba3dab2bfd.jpg"))
        waltDisney.add(catergoriaItem(1,"https://image.cdn0.buscalibre.com/3024184.__RS360x360__.jpg"))
        waltDisney.add(catergoriaItem(1,"https://static.wikia.nocookie.net/disney/images/9/96/LosTresCaballeros.png/revision/latest?cb=20111211173245&path-prefix=es"))

        val seriesAccion: MutableList<catergoriaItem> = ArrayList()
        seriesAccion.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/poster_bigshot_70ac9ab4.png"))
        seriesAccion.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/secret-sulphur-spring-poster_09ecf8a3.jpeg?region=0%2C0%2C2827%2C3736"))
        seriesAccion.add(catergoriaItem(1,"https://seriesflix.nu/wp-content/uploads/2021/07/behind-the-attraction-81527-poster-683x1024.jpg"))
        seriesAccion.add(catergoriaItem(1,"https://pbs.twimg.com/media/EnN4SdxXUAAcK52.jpg"))
        seriesAccion.add(catergoriaItem(1,"https://pm1.narvii.com/7381/2ec23746000595936fbdb5b84d59d15a874f373cr1-1090-1600v2_hq.jpg"))
        seriesAccion.add(catergoriaItem(1,"https://static.wikia.nocookie.net/disney/images/c/cd/HannahMontana-Lo-Mejor-de-ambos-mundos-en-concierto.jpg/revision/latest?cb=20100626122205&path-prefix=es"))

        val Animadas: MutableList<catergoriaItem> = ArrayList()
        Animadas.add(catergoriaItem(1,"https://i.pinimg.com/originals/f8/14/49/f81449f847ff7606090a0bb0dea87e7d.jpg"))
        Animadas.add(catergoriaItem(1,"https://static.wikia.nocookie.net/todocine/images/4/47/Portada_rio.jpg/revision/latest?cb=20120813094644&path-prefix=es"))
        Animadas.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/image_07f1aaf3.jpeg?region=0%2C0%2C540%2C810"))
        Animadas.add(catergoriaItem(1,"https://es.web.img3.acsta.net/medias/nmedia/18/73/54/02/20415767.jpg"))
        Animadas.add(catergoriaItem(1,"https://r4.abcimg.es/resizer/resizer.php?imagen=https%3A%2F%2Fstatic4.abc.es%2Fmedia%2Fpeliculas%2F000%2F025%2F460%2Fmulan-1.jpg&nuevoancho=690&medio=abc"))
        Animadas.add(catergoriaItem(1,"https://i.pinimg.com/originals/3b/32/eb/3b32eb3a53430a33f3820895073bce6d.jpg"))
        Animadas.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/6/6f/28a.jpg/revision/latest?cb=20200812013209&path-prefix=es"))

        val liveAction: MutableList<catergoriaItem> = ArrayList()
        liveAction.add(catergoriaItem(1,"https://www.eluniverso.com/resizer/dIeWBB5pbcN1xMeRNPQD6CsumIs=/arc-anglerfish-arc2-prod-eluniverso/public/IRN2ZUZFANAXVNKJZL62RNJEB4.jpg"))
        liveAction.add(catergoriaItem(1,"https://m.media-amazon.com/images/I/81M1e7c8XbL._SY445_.jpg"))
        liveAction.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/image_9e35a739.jpeg?region=0%2C0%2C540%2C810"))
        liveAction.add(catergoriaItem(1,"https://upload.wikimedia.org/wikipedia/en/c/c2/Cinderella_2015_official_poster.jpg"))
        liveAction.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/19/07/09/11/22/4517830.jpg"))
        liveAction.add(catergoriaItem(1,"https://es.web.img3.acsta.net/c_310_420/medias/nmedia/18/87/58/97/20040514.jpg"))
        liveAction.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/p_dumbo_19753_7f6610fc.jpeg?region=0,0,540,810"))

        val musicales: MutableList<catergoriaItem> = ArrayList()
        musicales.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/open-uri20150422-12561-jokmnn_086b886c.jpeg?region=0%2C0%2C1000%2C1487"))
        musicales.add(catergoriaItem(1,"https://i.pinimg.com/originals/63/d1/11/63d11178750977d0872522a49b9fb2f8.jpg"))
        musicales.add(catergoriaItem(1,"https://cdn.film-fish.com/uploads/movie/c9dd3d4bfc7c01991d658146fdd57f58.jpg"))
        musicales.add(catergoriaItem(1,"https://the-peak.ca/wp-content/uploads/2018/07/camp-rock.jpeg"))
        musicales.add(catergoriaItem(1,"https://alienstips.com/wp-content/uploads/2021/01/et-It-Shine-2012.jpg"))

        val SeriesDisneyChannel: MutableList<catergoriaItem> = ArrayList()
        SeriesDisneyChannel.add(catergoriaItem(1,"https://es.web.img2.acsta.net/pictures/19/09/29/10/35/5133862.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://m.media-amazon.com/images/I/81M1e7c8XbL._SY445_.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/6/67/Abordo.jpg/revision/latest/top-crop/width/360/height/450?cb=20180125172753&path-prefix=es"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://www.formulatv.com/images/series/posters/300/378/dest_1.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/14/02/03/13/45/538200.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/14/01/30/18/07/456916.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://www.cine.com/media/series/423.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/3/3a/El_mundo_de_Riley.jpg/revision/latest?cb=20200721010739&path-prefix=es"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/b/bc/Sunny_entre_estrellas.jpg/revision/latest/top-crop/width/360/height/450?cb=20200719231247&path-prefix=es"))

        val PeliculasDisneyChannel: MutableList<catergoriaItem> = ArrayList()
        PeliculasDisneyChannel.add(catergoriaItem(1,"https://cdn6.dibujos.net/images/listas/85/16-deseos.jpg"))
        PeliculasDisneyChannel.add(catergoriaItem(1,"https://imgur.com/oTVtENq.jpg"))
        PeliculasDisneyChannel.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/movie_poster_zootopia_866a1bf2.jpeg"))
        PeliculasDisneyChannel.add(catergoriaItem(1,"https://i.pinimg.com/474x/4e/b8/3b/4eb83b2c127b1c81730e9a0f55551a78--halloween-movies-holiday-movies.jpg"))
        PeliculasDisneyChannel.add(catergoriaItem(1,"https://i.pinimg.com/originals/05/03/d0/0503d05baa7d1b6e4a3d8e4f49f30bab.jpg"))
        PeliculasDisneyChannel.add(catergoriaItem(1,"https://estaticos.marie-claire.es/media/cache/680x_thumb/uploads/images/gallery/5f11eef75bafe82f60f05f06/disney-channel-sharpay.jpg"))
//**********************************************************************
        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Originales",Originales))
        categorias.add(Categorias("Inspirados en los parques de Disney",InspiradosParquesDisney))
        categorias.add(Categorias("Walt Disney Animation Studio",waltDisney))
        categorias.add(Categorias("Series y especiales de accion en vivo",seriesAccion))
        categorias.add(Categorias("Mas películas animadas",Animadas))
        categorias.add(Categorias("Películas en live-action",liveAction))
        categorias.add(Categorias("Musicales",musicales))
        categorias.add(Categorias("Series y especiales de Disney Channel",SeriesDisneyChannel))
        categorias.add(Categorias("Peliculas de Disney Channel",PeliculasDisneyChannel))


        setCategoriasRecycleView(categorias)
    }

    private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvDisney)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }
}