package com.example.mvvmsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmsample.repo.MovieRepository
import com.example.mvvmsample.utils.Resource
import kotlinx.coroutines.Dispatchers

/**
 *Created by tarikul on 6/9/20
 */

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = movieRepository.getMovies()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}
