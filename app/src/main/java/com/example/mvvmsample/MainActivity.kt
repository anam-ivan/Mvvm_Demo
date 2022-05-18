package com.example.mvvmsample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsample.api.ApiHelper
import com.example.mvvmsample.api.RetrofitBuilder
import com.example.mvvmsample.utils.Status
import com.example.mvvmsample.viewmodel.MovieViewModel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MovieViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getMovies().observe(this, Observer { it ->
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        /*recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE*/
                        resource.data?.let {
                            it.size
                            Log.d("cbbc", it.size.toString())
                            Toast.makeText(
                            this@MainActivity,
                            Gson().toJson(it),
                            Toast.LENGTH_SHORT
                        ).show()}
                    }
                    Status.ERROR -> {
                        /*recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE*/
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        /*progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE*/
                    }
                }

            }
        })
    }
}