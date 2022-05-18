package com.example.mvvmsample.model

object RequestBodies {

    data class LoginBody(
        val email:String,
        val password:String
    )

}