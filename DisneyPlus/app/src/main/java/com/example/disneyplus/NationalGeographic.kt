package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NationalGeographic : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_national_geographic)

        val imgDisney: ImageView
        imgDisney=findViewById(R.id.img_national)
        Picasso.get().load("https://img.interempresas.net/fotos/2729372.png").into(imgDisney);

        val Series: MutableList<catergoriaItem> = ArrayList()
        Series.add(catergoriaItem(1, "https://cdn1.edgedatg.com/aws/v2/natgeotv/LifeBelowZero/showimages/0f54b40c58454d4fa23886c12af24abd/227x303-Q80_0f54b40c58454d4fa23886c12af24abd.jpg"))
        Series.add(catergoriaItem(1, "https://cdn1.edgedatg.com/aws/v2/natgeo/PrimalSurvivor/showimages/95a97268d47040b0d13b4ffe395c1d02/227x303-Q80_95a97268d47040b0d13b4ffe395c1d02.jpg"))
        Series.add(catergoriaItem(1, "https://cloudfront-us-east-1.images.arcpublishing.com/gruponacion/B6HCPKIV65ASHNDMGYVE55ULCY.jpg"))
        Series.add(catergoriaItem(1, "https://www.gannett-cdn.com/presto/2021/05/11/PDTF/4b8eae07-b29c-44ca-b774-20d2a4144cd0-GordonRamsey_06.JPG"))
        Series.add(catergoriaItem(1, "https://www.clofan.com/wp-content/uploads/2020/04/one-strange-rock.jpg"))
        Series.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_insideout_19751_af12286c.jpeg"))
        Series.add(catergoriaItem(1, "https://cdn1.edgedatg.com/aws/v2/natgeotv/TraffickedwithMarianavanZeller/showimages/1cd5205b7f5d8cdf2864bab11005ef56/227x303-Q80_1cd5205b7f5d8cdf2864bab11005ef56.jpg"))

        val Peliculas: MutableList<catergoriaItem> = ArrayList()
        Peliculas.add(catergoriaItem(1, "https://images.moviefit.me/t/o/214250-national-geographic-lost-kingdoms-of-the-maya.jpg"))
        Peliculas.add(catergoriaItem(1, "https://m.media-amazon.com/images/I/71yH2DLG-TL._SY445_.jpg"))
        Peliculas.add(catergoriaItem(1, "https://images.moviefit.me/t/m/254278-birth-of-civilization.jpg"))
        Peliculas.add(catergoriaItem(1, "https://www.nationalgeographic.com.es/medio/2021/03/15/ng-noviembre-2019-numero-455_b97df0e0_1280x1857.jpg"))
        Peliculas.add(catergoriaItem(1, "https://1.bp.blogspot.com/-_nXhs176LJs/X-t7GrWO_JI/AAAAAAAAEWM/CH9x3zBMYnUfbcAkgScjwXcrMbuipOo0gCLcBGAsYHQ/s1500/DDTM-TVLaint.jpg"))
        Peliculas.add(catergoriaItem(1, "https://m.media-amazon.com/images/I/71yH2DLG-TL._SY445_.jpg"))

        val Mascotas: MutableList<catergoriaItem> = ArrayList()
        Mascotas.add(catergoriaItem(1, "https://es.web.img2.acsta.net/pictures/21/07/09/15/33/5046399.jpg"))
        Mascotas.add(catergoriaItem(1, "https://4.bp.blogspot.com/-B-sMGIgv95M/XwGBkIGotMI/AAAAAAAAMiU/vZ-bRxK7bboHC-hCsI7lMDoV7z0vKZjGQCPcBGAsYHg/w500/jprquSROhLbm9ZsPWXaVROuBcie.jpg"))
        Mascotas.add(catergoriaItem(1, "https://files.magzter.com/resize/magazine/1463043303/1622486841/view/2.jpg"))
        Mascotas.add(catergoriaItem(1, "https://www.nationalgeographic.com.es/medio/2021/04/19/_f66164f8_550x807.jpg"))
        Mascotas.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/thelastice-poster_1080x1600_68f3c53e.jpeg?region=0%2C0%2C1080%2C1600"))
        Mascotas.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/docfilmswebsite_1080x1600_jane_6117ae61.jpeg?region=0%2C0%2C1080%2C1600"))

        val Ciencia: MutableList<catergoriaItem> = ArrayList()
        Ciencia.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/docfilmswebsite_1080x1600_sciencefair_4b1f7f2e.jpeg"))
        Ciencia.add(catergoriaItem(1, "https://m.media-amazon.com/images/I/51gjdicvEwL._SL500_.jpg"))
        Ciencia.add(catergoriaItem(1, "https://www.depositohidrografico.com/data/productos/ek0478.jpg"))
        Ciencia.add(catergoriaItem(1, "https://static.wikia.nocookie.net/doblaje/images/c/c4/MV5BZDVjY2M3ODMtZmE4Zi00ODQ2LWI2OWMtYTYyNTA3MDhhNGQ5XkEyXkFqcGdeQXVyMTY5Nzc4MDY%40._V1_.jpg/revision/latest?cb=20201015144457&path-prefix=es"))
        Ciencia.add(catergoriaItem(1, "https://es.web.img2.acsta.net/pictures/21/07/09/15/33/5046399.jpg"))

        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Series",Series))
        categorias.add(Categorias("Películas",Peliculas))
        categorias.add(Categorias("Veterinarias y Mascotas",Mascotas))
        categorias.add(Categorias("Ciencia e Innovación",Ciencia))

        setCategoriasRecycleView(categorias)
    }
    private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvNational)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }
}