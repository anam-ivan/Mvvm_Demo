package com.example.mvvmsample.repo

import com.example.mvvmsample.api.ApiHelper

/**
 *Created by tarikul on 6/9/20
 */

class MovieRepository(private val apiHelper: ApiHelper) {
    suspend fun getMovies() = apiHelper.getMovies()
}
