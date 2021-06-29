package com.example.moviles01

class BBaseDatosMemoria{
    companion object{
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                    .add(
                            BEntrenador("Adrian", "a@a.com")
                    )
            arregloBEntrenador
                    .add(
                            BEntrenador("Alex", "b@a.com")
                    )
            arregloBEntrenador
                    .add(
                            BEntrenador("Ali", "d@a.com")
                    )
        }
    }
}