package com.example.firebaseuno.dto

class FirestoreUsuarioDto(
    val uid: String="",
    val email: String="",
    var roles: ArrayList<String> = arrayListOf()
)
{

}