package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var ImagenesRecicleView : RecyclerView?=null
    private var botonesRecycle: RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null
    private var recyclerImagenes: imageSliderAdapter?=null
    private var botones: ItemOpctionAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)


        //Opciones Disney Pixar
        val OpcionesCategorias: MutableList<ItemOpcion> = ArrayList()
        OpcionesCategorias.add(ItemOpcion(R.drawable.disney))
        OpcionesCategorias.add(ItemOpcion(R.drawable.pixar))
        OpcionesCategorias.add(ItemOpcion(R.drawable.marvel))
        OpcionesCategorias.add(ItemOpcion(R.drawable.star_wars))
        OpcionesCategorias.add(ItemOpcion(R.drawable.national))


        //Peliculas
        //RECOMENDACIONES PARA TI
        val RecomendacionesParaTi: MutableList<catergoriaItem> = ArrayList()
        RecomendacionesParaTi.add(catergoriaItem(1, "https://static.wikia.nocookie.net/marvelcinematicuniverse/images/2/2b/The_Avengers_Poster.png/revision/latest?cb=20150610135853&path-prefix=es"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://m.media-amazon.com/images/I/71gkoqbpjDL._SY445_.jpg"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://r1.abcimg.es/resizer/resizer.php?imagen=https%3A%2F%2Fstatic2.abc.es%2Fmedia%2Fpeliculas%2F000%2F050%2F813%2Flos-increibles-2-1.jpg&nuevoancho=690&medio=abc"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://es.web.img3.acsta.net/pictures/14/06/17/14/04/353959.jpg"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://img.betaseries.com/iyPtn_8FCFGdNkmNOVQSFSCKktI=/600x900/smart/https%3A%2F%2Fpictures.betaseries.com%2Ffonds%2Fposter%2Ff9f04e0418dfceb9f349cc4a81c84775.jpg"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://www.formulatv.com/images/series/posters/1200/1274/dest_3.jpg"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://static.wikia.nocookie.net/disney/images/c/cc/Luca_poster.jpg/revision/latest?cb=20210428135001&path-prefix=es"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://es.web.img2.acsta.net/pictures/20/09/10/10/45/2280684.jpg"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/image_7ff71125.jpeg?region=0%2C0%2C540%2C810"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/image_5e27f8d3.jpeg?region=0,0,648,972"))
        RecomendacionesParaTi.add(catergoriaItem(1, "https://spoiler.bolavip.com/export/sites/bolavip/img/2021/01/29/raya_and_the_last_dragon_cuando_se_estrena_en_disneyx.jpg_1626445525.jpg"))


        //
        val NovedadesDisney: MutableList<catergoriaItem> = ArrayList()
        NovedadesDisney.add(catergoriaItem(1,"https://static.wikia.nocookie.net/disney/images/c/cc/22_vs_Earth_poster.jpg/revision/latest?cb=20210516170730&path-prefix=es"))
        NovedadesDisney.add(catergoriaItem(1,"https://i.blogs.es/4e81f6/onward_teaser_poster/450_1000.jpg"))
        NovedadesDisney.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/19/11/26/13/22/4959965.jpg"))
        NovedadesDisney.add(catergoriaItem(1,"https://m.media-amazon.com/images/M/MV5BZDA1ZmQ2OGMtZDhkMC00ZjRkLWE3ZTMtMzA5ZTk0YjM1OGRmXkEyXkFqcGdeQXVyNzI1NzMxNzM@._V1_.jpg"))
        NovedadesDisney.add(catergoriaItem(1,"https://files.liveworksheets.com/def_files/2021/5/27/10527150938773411/10527150938773411001.jpg"))
        NovedadesDisney.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/image_23120c18.jpeg"))
        NovedadesDisney.add(catergoriaItem(1,"https://m.media-amazon.com/images/M/MV5BNjRmNDI5MjMtMmFhZi00YzcwLWI4ZGItMGI2MjI0N2Q3YmIwXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UY1200_CR90,0,630,1200_AL_.jpg"))
        NovedadesDisney.add(catergoriaItem(1,"https://pelisenhd.net/wp-content/uploads/2021/07/sChTuxwVuajaoctBBfMcGoaWoru.jpg"))
        NovedadesDisney.add(catergoriaItem(1,"https://images-na.ssl-images-amazon.com/images/I/81CpfGZBUkL.jpg"))
        NovedadesDisney.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/key_art_4_5_lat_0703b9c3.jpeg?region=0,31,1080,1270&width=960"))

        val Originales: MutableList<catergoriaItem> = ArrayList()
        Originales.add(catergoriaItem(1, "https://www.disneylapresspack.com/storage/programs/1624997076_MAW_S1_27x40_ACT43096_LOC_LAS.jpg"))
        Originales.add(catergoriaItem(1,"https://images-na.ssl-images-amazon.com/images/I/71zzK7+mLUL.jpg"))
        Originales.add(catergoriaItem(1,"https://arc-anglerfish-arc2-prod-infobae.s3.amazonaws.com/public/ECO2YTA6SBA2JCVMV3X7S4KONE.jpg"))
        Originales.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/14/03/11/09/33/450247.jpg"))
        Originales.add(catergoriaItem(1,"https://static.wikia.nocookie.net/frozen/images/7/72/Frozen_Fever_PosterHD.png/revision/latest?cb=20150311021826&path-prefix=es"))
        Originales.add(catergoriaItem(1,"https://i.pinimg.com/originals/9d/71/15/9d711579b2fb48b56e2436dfed8974e5.jpg"))
        Originales.add(catergoriaItem(1,"https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/peliculas/piratas-del-caribe-la-venganza-de-salazar/119544770-3-esl-ES/Piratas-del-Caribe-La-venganza-de-Salazar.jpg?resize=320:*"))
        Originales.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/image_9e35a739.jpeg?region=0%2C0%2C540%2C810"))
        Originales.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/20/03/20/15/13/0225217.jpg"))
        Originales.add(catergoriaItem(1,"https://www.ecartelera.com/carteles/12500/12573/004_m.jpg"))

        val InspiradosEnParquesDisney: MutableList<catergoriaItem> = ArrayList()
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5nX1XqSnq9J_QB-1jCfy21h9QsySH6R_2y32eLrGtSr2qJotupGkhhybYVZm2w-FvXuw&usqp=CAU"))
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://seriesflix.nu/wp-content/uploads/2021/07/behind-the-attraction-81527-poster-683x1024.jpg"))
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/peliculas/piratas-del-caribe-la-venganza-de-salazar/119544770-3-esl-ES/Piratas-del-Caribe-La-venganza-de-Salazar.jpg?resize=320:*"))
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/19/05/08/16/59/2526525.jpg"))
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/19/01/22/16/26/2486964.jpg"))
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://es.web.img3.acsta.net/medias/nmedia/18/70/33/62/20122901.jpg"))
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://static.wikia.nocookie.net/descendientes-disney/images/1/19/Descendientes_2_p%C3%B3ster.jpg/revision/latest?cb=20200728065054&path-prefix=es"))
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://www.planetadelibros.com.ec/usuaris/libros/fotos/261/m_libros/260914_portada_la-bella-y-la-bestia-el-libro-de-la-pelicula_disney_201704121648.jpg"))
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/16/02/15/14/51/400512.jpg"))
        InspiradosEnParquesDisney.add(catergoriaItem(1,"https://es.web.img2.acsta.net/pictures/14/11/25/12/32/329196.jpg"))

        val UniversoMarvel: MutableList<catergoriaItem> = ArrayList()
        UniversoMarvel.add(catergoriaItem(1,"https://images.clarin.com/2021/04/05/el-afiche-de-loki-con___n0zI0_5PB_720x0__1.jpg"))
        UniversoMarvel.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/p_wandavision_disneyplus_poster03_20118_66028c77.jpeg"))
        UniversoMarvel.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/capitana-marvel-poster-1551691489.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/vengadores-infinity-war-poster-1551691493.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/vengadores-endgame-orden-peli-culas-marvel-1556096718.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/vengadores-era-de-ultron-poster-1551691493.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/thor-poster-1551691493.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/thor-ragnarok-poster-1551691493.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/el-increible-hulk-poster-1551691489.jpg?crop=1xw:1xh;center,top&resize=480:*"))
        UniversoMarvel.add(catergoriaItem(1,"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/iron-man-3-1525787309.jpg?crop=1xw:1xh;center,top&resize=480:*"))

        val Tendencias: MutableList<catergoriaItem> = ArrayList()
        Tendencias.add(catergoriaItem(1,"https://www.disneylapresspack.com/storage/programs/1583944281_bluey.jpg"))
        Tendencias.add(catergoriaItem(1,"https://es.web.img2.acsta.net/pictures/17/08/17/17/51/059243.jpg"))
        Tendencias.add(catergoriaItem(1,"https://r4.abcimg.es/resizer/resizer.php?imagen=https%3A%2F%2Fstatic3.abc.es%2Fmedia%2Fseries%2F000%2F002%2F497%2Fjessie-1.jpg&nuevoancho=683&medio=abc"))
        Tendencias.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/14/09/01/13/43/553593.jpg"))
        Tendencias.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/1/12/High_school_musical_xlg.jpg/revision/latest?cb=20200826175615&path-prefix=es"))
        Tendencias.add(catergoriaItem(1,"https://static.wikia.nocookie.net/marvelcinematicuniverse/images/a/ae/The_Falcon_and_the_Winter_Soldier_-_P%C3%B3ster_primera_temporada_2.png/revision/latest?cb=20210208012021&path-prefix=es"))
        Tendencias.add(catergoriaItem(1,"https://spoiler.bolavip.com/export/sites/bolavip/img/2021/03/30/exu6wx0uyaalac6.jfif_1355442878.jfif"))
        Tendencias.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/image_07f1aaf3.jpeg?region=0%2C0%2C540%2C810"))
        Tendencias.add(catergoriaItem(1,"https://r1.abcimg.es/resizer/resizer.php?imagen=https%3A%2F%2Fstatic1.abc.es%2Fmedia%2Fpeliculas%2F000%2F018%2F775%2Flos-increibles-1.jpg&nuevoancho=690&medio=abc"))
        Tendencias.add(catergoriaItem(1,"https://images.clarin.com/2021/04/05/el-afiche-de-loki-con___n0zI0_5PB_720x0__1.jpg"))

        val SeriesAnimadas: MutableList<catergoriaItem> = ArrayList()
        SeriesAnimadas.add(catergoriaItem(1,"https://www.tebeosfera.com/T3content/img/T3_series/l/e/chip_n_dale.png"))
        SeriesAnimadas.add(catergoriaItem(1,"https://r3.abcimg.es/resizer/resizer.php?imagen=https%3A%2F%2Fstatic1.abc.es%2Fmedia%2Fseries%2F000%2F002%2F389%2Fphineas-y-ferb-1.jpg&nuevoancho=690&medio=abc"))
        SeriesAnimadas.add(catergoriaItem(1,"https://static.wikia.nocookie.net/disney/images/5/51/Gravity_falls_poster.jpg/revision/latest?cb=20161114045752&path-prefix=es"))
        SeriesAnimadas.add(catergoriaItem(1,"https://m.media-amazon.com/images/M/MV5BMjAyYTNjNDAtZDYyMC00NWFlLWI1OWEtYzIzYzRlNzg4YWQ2L2ltYWdlXkEyXkFqcGdeQXVyMzM4NjcxOTc@._V1_FMjpg_UX1000_.jpg"))
        SeriesAnimadas.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/b/bb/LocurasEmperador.JPG/revision/latest?cb=20171110232933&path-prefix=es"))
        SeriesAnimadas.add(catergoriaItem(1,"https://elcomercio.pe/resizer/pdN_gzkrAdnTRYzOshsdqjA6oTQ=/620x0/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/3DCLZI35YFFGBJ2FFEBUF3WLKU.jpg"))
        SeriesAnimadas.add(catergoriaItem(1,"https://es.web.img2.acsta.net/pictures/16/02/10/17/20/437843.jpg"))
        SeriesAnimadas.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/p_handymanny_21234_225aa11b.jpeg"))
        SeriesAnimadas.add(catergoriaItem(1,"https://lacartoons.com/system/series/portadas/000/000/318/original/Kim-Possible-600x900.jpg?1593524560"))
        SeriesAnimadas.add(catergoriaItem(1,"https://m.media-amazon.com/images/M/MV5BMTdiNDIyMGEtNWJjMi00ODlhLWJhM2EtYjJjMjFlMjNhNDEwXkEyXkFqcGdeQXVyODg3NDc1OTE@._V1_.jpg"))

        val PeliculasAnimadas: MutableList<catergoriaItem> = ArrayList()
        PeliculasAnimadas.add(catergoriaItem(1,"https://i.blogs.es/4e81f6/onward_teaser_poster/450_1000.jpg"))
        PeliculasAnimadas.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/p_rayaandthelastdragon_21294_83346778.jpeg"))
        PeliculasAnimadas.add(catergoriaItem(1,"https://flxt.tmsimg.com/assets/p190662_p_v13_az.jpg"))
        PeliculasAnimadas.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/p_insideout_19751_af12286c.jpeg"))
        PeliculasAnimadas.add(catergoriaItem(1,"https://resizing.flixster.com/EseiGdiedSh6jsMfgPcRbruGJtA=/ems.ZW1zLXByZC1hc3NldHMvbW92aWVzL2FiZWI5MTcwLWE0ZTctNGQyNy05NWJlLTM3MzMxMTliZDlhNS53ZWJw"))
        PeliculasAnimadas.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/p_theprincessandthefrog_20499_1c5f55a1.jpeg"))
        PeliculasAnimadas.add(catergoriaItem(1,"https://images-na.ssl-images-amazon.com/images/I/91MeaUr78gL._RI_.jpg"))
        PeliculasAnimadas.add(catergoriaItem(1,"https://es.web.img2.acsta.net/c_310_420/pictures/14/02/06/10/16/315588.jpg"))
        PeliculasAnimadas.add(catergoriaItem(1,"https://es.web.img3.acsta.net/medias/nmedia/18/79/96/30/19541005.jpg"))
        PeliculasAnimadas.add(catergoriaItem(1,"https://static.toiimg.com/thumb/msid-61238512,width-219,height-317,imgsize-49241/61238512.jpg"))

        val NuevasVersionesClasicos: MutableList<catergoriaItem> = ArrayList()
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://estereofonica.com/wp-content/uploads/2021/06/socios-y-sabuesos-la-nueva-serie-de-disney-plus-que-llegara-cargada-de-diversion_turnerandhooch.jpg"))
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://www.eluniverso.com/resizer/dIeWBB5pbcN1xMeRNPQD6CsumIs=/arc-anglerfish-arc2-prod-eluniverso/public/IRN2ZUZFANAXVNKJZL62RNJEB4.jpg"))
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://images-na.ssl-images-amazon.com/images/I/914MHuDfMSL.jpg"))
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/19/01/22/16/26/2486964.jpg"))
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/image_9e35a739.jpeg?region=0%2C0%2C540%2C810"))
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://upload.wikimedia.org/wikipedia/en/c/c2/Cinderella_2015_official_poster.jpg"))
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://es.web.img3.acsta.net/medias/nmedia/18/70/33/62/20122901.jpg"))
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://m.media-amazon.com/images/I/81M1e7c8XbL._SY445_.jpg"))
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://i0.wp.com/enrilemoine.com/wp-content/uploads/2017/03/La-Bella-y-La-Bestia.jpg?fit=585%2C760&ssl=1"))
        NuevasVersionesClasicos.add(catergoriaItem(1,"https://lh6.googleusercontent.com/proxy/JNy02xkGIl4C6VVMjCxXPwKgaIrmRqTbtpcg6jH_NNTHrUxjtc4P_B3EF64or4FolN4zYVftsPoYAlSkTK5KQrchf2QlMPwBmDITBb6RY2n0yJR302xA6YrMzblEKw=s0-d"))

        val SeriesDisneyChannel: MutableList<catergoriaItem> = ArrayList()
        SeriesDisneyChannel.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/14/02/03/13/45/538200.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://es.web.img3.acsta.net/pictures/14/01/30/18/07/456916.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://www.cine.com/media/series/423.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://es.web.img2.acsta.net/pictures/19/09/29/10/35/5133862.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://m.media-amazon.com/images/I/81M1e7c8XbL._SY445_.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/6/67/Abordo.jpg/revision/latest/top-crop/width/360/height/450?cb=20180125172753&path-prefix=es"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://www.formulatv.com/images/series/posters/300/378/dest_1.jpg"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/3/3a/El_mundo_de_Riley.jpg/revision/latest?cb=20200721010739&path-prefix=es"))
        SeriesDisneyChannel.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/b/bc/Sunny_entre_estrellas.jpg/revision/latest/top-crop/width/360/height/450?cb=20200719231247&path-prefix=es"))
//**********************************************************************
        val AccionesAventuras: MutableList<catergoriaItem> = ArrayList()
        AccionesAventuras.add(catergoriaItem(1,"https://r2.abcimg.es/resizer/resizer.php?imagen=https%3A%2F%2Fstatic1.abc.es%2Fmedia%2Fpeliculas%2F000%2F058%2F434%2Fviuda-negra-1.jpg&nuevoancho=151&medio=abc"))
        AccionesAventuras.add(catergoriaItem(1,"https://www.mundoprimaria.com/wp-content/uploads/2020/02/67-VIAJE-AL-CENTRO-DE-LA-TIERRA-2008.jpg"))
        AccionesAventuras.add(catergoriaItem(1,"https://www.estrenosdecine.eu/media/k2/items/cache/e7277808c4aa05fb2cf4c50d19d09f07_M.jpg"))
        AccionesAventuras.add(catergoriaItem(1,"https://www.lafilacero.com/covers/215/126331559905157.jpg?7"))
        AccionesAventuras.add(catergoriaItem(1,"https://tupersonajefavorito.com/wp-content/uploads/2020/03/JUNGLE-CRUISE-1.jpg"))
        AccionesAventuras.add(catergoriaItem(1,"https://hips.hearstapps.com/es.h-cdn.co/crfes/images/ninos/ocio/peliculas-para-ver-en-familia/el-planeta-del-tesoro/3633473-1-esl-ES/El-planeta-del-tesoro.jpg"))
        AccionesAventuras.add(catergoriaItem(1,"https://lumiere-a.akamaihd.net/v1/images/finest_hour_payoff_b5b18874.jpeg?region=0%2C0%2C300%2C450"))
        AccionesAventuras.add(catergoriaItem(1,"https://www.ecartelera.com/carteles/12500/12526/025_p.jpg"))
        AccionesAventuras.add(catergoriaItem(1,"https://hips.hearstapps.com/es.h-cdn.co/crfes/images/ninos/ocio/peliculas-para-ver-en-familia/brave-indomable/3633391-1-esl-ES/Brave-Indomable.jpg"))
        AccionesAventuras.add(catergoriaItem(1,"https://es.web.img3.acsta.net/c_310_420/medias/nmedia/18/85/24/77/19995859.jpg"))

        val PelicuasPrincipales: MutableList<catergoriaItem> = ArrayList()
        PelicuasPrincipales.add(catergoriaItem(1,"https://www.mundoprimaria.com/wp-content/uploads/2020/02/9-ALADD%C3%8DN-2019.jpg"))
        PelicuasPrincipales.add(catergoriaItem(1,"https://hips.hearstapps.com/es.h-cdn.co/crfes/images/ninos/ocio/peliculas-para-ver-en-familia/brave-indomable/3633391-1-esl-ES/Brave-Indomable.jpg"))
        PelicuasPrincipales.add(catergoriaItem(1,"https://lh3.googleusercontent.com/proxy/2O3mQz6b5xqn4Z9S8md86X-woz3gcEVVLEaN1g5CYrOdBK2pdJUBzdCxY4e_AJTW27poFo3EzSo_tN6NqmikOeVxeZ42HcpQ-b0"))
        PelicuasPrincipales.add(catergoriaItem(1,"https://static.wikia.nocookie.net/disney/images/c/cc/Luca_poster.jpg/revision/latest?cb=20210428135001&path-prefix=es"))
        PelicuasPrincipales.add(catergoriaItem(1,"https://static.wikia.nocookie.net/disney/images/6/63/Disney-tarzan.jpg/revision/latest?cb=20160923002241&path-prefix=es"))
        PelicuasPrincipales.add(catergoriaItem(1,"https://i0.wp.com/www.nolapeles.com/wp-content/uploads/2020/03/opinion-unidos-disney-pixar-poster.jpg?resize=659%2C854&ssl=1"))
        PelicuasPrincipales.add(catergoriaItem(1,"https://static.wikia.nocookie.net/disney/images/4/4d/Maleficent_poster.png/revision/latest?cb=20140514145417&path-prefix=es"))
        PelicuasPrincipales.add(catergoriaItem(1,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzjPaVYJWv1jZZqC9Yd1aF6Iya-mI13Dh06g&usqp=CAU"))
        PelicuasPrincipales.add(catergoriaItem(1,"https://i.pinimg.com/236x/30/0f/b9/300fb96b349cd81083098157059b204d.jpg"))
        PelicuasPrincipales.add(catergoriaItem(1,"https://www.ecured.cu/images/d/de/Mulan.jpg"))

        val Pixar: MutableList<catergoriaItem> = ArrayList()
        Pixar.add(catergoriaItem(1,"https://i.pinimg.com/236x/71/94/e8/7194e826075aa5c027ea8d796d886dc0.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://www.tododisca.com/wp-content/uploads/2019/11/Corto-Loop.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/0e7ebd/abugslife/450_1000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.pinimg.com/originals/6c/88/eb/6c88eb077eb9bbb481514c1c5d74486e.jpg"))
        Pixar.add(catergoriaItem(1,"https://static.wikia.nocookie.net/doblaje/images/1/15/Boundin%27_poster.jpg/revision/latest/top-crop/width/360/height/450?cb=20190125223011&path-prefix=es"))
        Pixar.add(catergoriaItem(1,"https://img.huffingtonpost.com/asset/5d42c8362400009d179371b1.jpeg?ops=scalefit_630_400_noupscale"))
        Pixar.add(catergoriaItem(1,"https://lh3.googleusercontent.com/proxy/bhGAs-f2pD5sdxaeRtorrhZTXzoMSdgjLPb1R_w90Mm1kJbwXM7-qLR3vLBS-ZQcrbj2jNmkU1dRkFzZkF1VRneTf8TnT6ldz3o9SxkpuYM8LFM2VbkldJ1eWaAjtr13lIsxsy8orw"))
        Pixar.add(catergoriaItem(1,"https://static.wixstatic.com/media/a27d24_dd6f04596bae4f89aecea8de8b5edcc0~mv2.jpg/v1/fill/w_1000,h_1481,al_c,q_90/a27d24_dd6f04596bae4f89aecea8de8b5edcc0~mv2.jpg"))
        Pixar.add(catergoriaItem(1,"https://static.wikia.nocookie.net/poohadventures/images/1/1c/Panda_poster.jpg/revision/latest?cb=20100403223534"))

        val Romance: MutableList<catergoriaItem> = ArrayList()
        Pixar.add(catergoriaItem(1,"https://i.pinimg.com/originals/a6/8a/f5/a68af5cfa0b478115ab948e7fd13fac4.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))

        val MusicaBaile: MutableList<catergoriaItem> = ArrayList()
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))

        val MickeyComapania: MutableList<catergoriaItem> = ArrayList()
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))

        val ExitosCine: MutableList<catergoriaItem> = ArrayList()
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))
        Pixar.add(catergoriaItem(1,"https://i.blogs.es/9a7f8b/bao/1366_2000.jpg"))

        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Recomendaciones para ti",RecomendacionesParaTi))
        categorias.add(Categorias("Novedades de Disney",NovedadesDisney))
        categorias.add(Categorias("Originales",Originales))
        categorias.add(Categorias("Inspirados en los parques de Disney",InspiradosEnParquesDisney))
        categorias.add(Categorias("Universo Cinematográfico de Marvel",UniversoMarvel))
        categorias.add(Categorias("Tendencias",Tendencias))
        categorias.add(Categorias("Series Animadas",SeriesAnimadas))
        categorias.add(Categorias("Películas Animadas",PeliculasAnimadas))
        categorias.add(Categorias("Nuevas versiones de clásicos",NuevasVersionesClasicos))
        categorias.add(Categorias("Series de Disney Channel",SeriesDisneyChannel))
        categorias.add(Categorias("Acción y aventura",AccionesAventuras))
        categorias.add(Categorias("Películas principales",PelicuasPrincipales))
        categorias.add(Categorias("Películas y cortometrajes de Pixar",Pixar))
        categorias.add(Categorias("Romance",Romance))
        categorias.add(Categorias("Música y baile",MusicaBaile))
        categorias.add(Categorias("Mickey y compañía",MickeyComapania))
        categorias.add(Categorias("Éxitos de cine",ExitosCine))

        val slider: MutableList<slider> = ArrayList()
        slider.add(slider(" para ti","https://www.gannett-cdn.com/-mm-/94a3cd2d216286c7f794a7e027e6e5bbc72f19c5/c=0-18-3000-1706/local/-/media/2020/11/02/Quincy/ghows-WL-200709313-54057191.jpg?width=660&height=372&fit=crop&format=pjpg&auto=webp"))
        slider.add(slider("Exitos de cine","https://peru21.pe/resizer/pqz6Ba4vgdXq7X8BXXESgIY6ktc=/580x330/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/23TMIJA4SVDSVMSRIDMJMHLNQU.jpg"))
        slider.add(slider("Exitos de cine","https://i.annihil.us/u/prod/marvel/images/OpenGraph-TW-1200x630.jpg"))
        slider.add(slider("Exitos de cine","https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/CFCB94112BFA34C7C1698BEC93EFA511824F608D0CE1FD9313A531F9ECA0EDA1/scale?width=1200&aspectRatio=1.78&format=jpeg"))
        slider.add(slider("Exitos de cine","https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/777431C0F19100A55C2052D71E790428A15088EDB26AE69196D4406112306292/scale?width=1200&aspectRatio=1.78&format=jpeg"))
        slider.add(slider("Exitos de cine","https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/FF9425756F5B6A8B6A0D2827F85B45BA96CF858D9B0CEF86B4F9E58F57BAF984/scale?width=1200&aspectRatio=1.78&format=jpeg"))
        slider.add(slider("Exitos de cine","https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/26EAC0AF82AC2083D2384020F5C47854F860CAC5E8C0F48F6359876DDB233E5A/scale?width=1200&aspectRatio=1.78&format=jpeg"))
        slider.add(slider("Exitos de cine","https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/4B95C840AF54D3C2580D53C19CFA240B0D9FD728A95A3F6814BD354CA746FF5F/scale?width=1200&aspectRatio=1.78&format=jpeg"))
        slider.add(slider("chip","https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/1E3C71C09EABC48BE2ED5941CC1BBCFD7718B8CDB0B872AE185EA2486FA04828/scale?width=1200&aspectRatio=1.78&format=jpeg"))

        setImagenesRecycleView(slider)
        setBotonesRecycleView(OpcionesCategorias)
        setCategoriasRecycleView(categorias)

    }

    private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvRecycleInicio)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }

    private fun setImagenesRecycleView(slider: List<slider>){
        ImagenesRecicleView = findViewById(R.id.rvImagenes)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        ImagenesRecicleView!!.layoutManager = layoutManager
        recyclerImagenes = imageSliderAdapter(this, slider)
        ImagenesRecicleView!!.adapter = recyclerImagenes
    }

    private fun setBotonesRecycleView(itemOpcion: List<ItemOpcion>){
        botonesRecycle = findViewById(R.id.rvBotones)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        botonesRecycle!!.layoutManager = layoutManager
        botones = ItemOpctionAdapter(this, itemOpcion)
        botonesRecycle!!.adapter = botones
    }
}