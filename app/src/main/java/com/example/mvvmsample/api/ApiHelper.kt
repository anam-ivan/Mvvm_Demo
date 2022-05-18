package com.example.mvvmsample.api
import com.example.mvvmsample.model.RequestBodies


class ApiHelper (private val apiService: ApiService) {

    suspend fun getMovies() = apiService.getAllMovies()

    suspend fun getLogin(user: RequestBodies.LoginBody) = apiService.loginUser(user)

    // suspend fun getLogin() = apiService.loginUser(body = RequestBodies)

    /*suspend fun getProducts() = apiService.getProducts()
    suspend fun getAllOfferedProducts(apiKeys: ApiKeyModel) =
        apiService.getAllOfferedProducts(apiKeys)*/
}