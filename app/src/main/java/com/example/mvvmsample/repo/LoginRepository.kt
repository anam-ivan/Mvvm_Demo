package com.example.mvvmsample.repo

import com.example.mvvmsample.api.ApiHelper
import com.example.mvvmsample.model.RequestBodies

class LoginRepository(private val apiHelper: ApiHelper) {
    // suspend fun loginUser(user: RequestBodies.LoginBody) = apiHelper.getLogin()

    suspend fun loginUser(user: RequestBodies.LoginBody) = apiHelper.getLogin(user)

    suspend fun demoLoginUser(user: RequestBodies.LoginBody) = apiHelper.getDemoLogin(user)

    suspend fun getPosts(page: Int) = apiHelper.getPosts(page)
}