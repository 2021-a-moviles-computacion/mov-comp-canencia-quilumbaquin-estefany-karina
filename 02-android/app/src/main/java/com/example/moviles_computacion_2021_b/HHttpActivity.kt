package com.example.moviles_computacion_2021_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
class HHttpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hhttp)

        //metodoGet()
        metodoPost()
    }

    private fun metodoPost() {
        val parametros: List<Pair<String, *>> = listOf(
            "title" to "Titulo móviles",
            "body" to "descripción móviles",
            "userId" to 1
        )

        "http://jsonplaceholder.typicode.com/posts"
            .httpPost(parametros)

    }

    fun metodoGet(){
        "http://jsonplaceholder.typicode.com/posts/1"
            .httpGet()
            .responseString{req, res, result->
                when(result){
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("http-klaxon","Error: ${error}")}
                        is Result.Success ->{
                            val getString = result.get()
                            Log.i("http-klaxon", "${getString}")

                            //"http://jsonplaceholder.typicode.com/posts/1" 1
                            //"http://jsonplaceholder.typicode.com/posts/1" muchos

                            val post = Klaxon()
                                .parse<IPostHttp>(getString)
                            Log.i("http-klaxon", "${post?.body}")
                    }
                }
            }
    }
}