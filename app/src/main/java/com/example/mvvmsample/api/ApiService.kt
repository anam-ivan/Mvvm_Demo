package com.example.mvvmsample.api

import com.example.mvvmsample.model.LoginResponse
import com.example.mvvmsample.model.Movie
import com.example.mvvmsample.model.RequestBodies
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @GET("movielist.json")
    suspend fun getAllMovies() : List<Movie>

    @POST("api/login")
    suspend fun loginUser(@Body body: RequestBodies.LoginBody): Response<LoginResponse>

    /*@POST("searchOld")
    suspend fun getProductsOld(@Body apiKey: ApiKeyModel): ProductModelOld


    @POST("searchOld")
    suspend fun getAllOfferedProducts(@Body apiKey: ApiKeyModel): ProductModelOld


    @GET("products/?page=2&limit=220&brand=bashundhara-1dded45d8")
    suspend fun getProducts(): ProductModel*/
}