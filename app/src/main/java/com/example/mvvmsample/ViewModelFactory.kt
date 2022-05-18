package com.example.mvvmsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsample.api.ApiHelper
import com.example.mvvmsample.repo.LoginRepository
import com.example.mvvmsample.repo.MovieRepository
import com.example.mvvmsample.viewmodel.LoginViewModel
import com.example.mvvmsample.viewmodel.MovieViewModel
import java.lang.IllegalArgumentException

/**
 *Created by tarikul on 5/9/20
 */
class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(MovieRepository(apiHelper)) as T
        } else if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(LoginRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}