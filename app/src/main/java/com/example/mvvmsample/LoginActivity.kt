package com.example.mvvmsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsample.api.ApiHelper
import com.example.mvvmsample.api.RetrofitBuilder
import com.example.mvvmsample.model.RequestBodies
import com.example.mvvmsample.utils.SessionManager
import com.example.mvvmsample.utils.Status
import com.example.mvvmsample.viewmodel.LoginViewModel
import com.google.gson.Gson

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var sessionManager : SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sessionManager = SessionManager(this)
        setupViewModel()
        // setupObservers()
        setupLoginObservers()
        getPosts()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(LoginViewModel::class.java)
    }
    /*private fun setupObservers() {
        val body = RequestBodies.LoginBody(
            email = "eve.holt@reqres.in",
            password = "cityslicka"
        )
        viewModel.getLogin(body).observe(this, Observer { it ->
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let {
                           *//* it.size
                            Log.d("cbbc", it.size.toString())
                            Toast.makeText(
                                this@MainActivity,
                                Gson().toJson(it),
                                Toast.LENGTH_SHORT
                            ).show()*//*
                            Toast.makeText(this, it.body()?.token, Toast.LENGTH_LONG).show()
                            it.body()?.token?.let { it1 -> sessionManager.saveAuthToken(it1) }
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                    Status.ERROR -> {
                        *//*recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE*//*
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        *//*progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE*//*
                    }
                }

            }
        })
    }*/

    private fun setupLoginObservers() {
        val body = RequestBodies.LoginBody(
            email = "anam1@gmail.com",
            password = "123456"
        )
        viewModel.getDemoLogin(body).observe(this, Observer { it ->
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let {
                            /* it.size
                             Log.d("cbbc", it.size.toString())
                             Toast.makeText(
                                 this@MainActivity,
                                 Gson().toJson(it),
                                 Toast.LENGTH_SHORT
                             ).show()*/
                            Toast.makeText(this, it.body()?.data?.Token, Toast.LENGTH_LONG).show()
                            it.body()?.data!!.Token?.let { it1 -> sessionManager.saveAuthToken(it1) }
                            /*val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()*/
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                    }
                }

            }
        })
    }

    private fun getPosts() {
        viewModel.getPosts(1).observe(this, Observer { it ->
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let {
                            it.body()?.data?.size?.let { it1 -> Toast.makeText(this, it1, Toast.LENGTH_LONG).show() }
                            }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                    }
                }

            }
        })
    }
}