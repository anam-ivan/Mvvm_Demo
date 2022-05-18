package com.example.mvvmsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsample.api.ApiHelper
import com.example.mvvmsample.api.RetrofitBuilder
import com.example.mvvmsample.model.RequestBodies
import com.example.mvvmsample.utils.Status
import com.example.mvvmsample.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupViewModel()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(LoginViewModel::class.java)
    }
    private fun setupObservers() {
        val body = RequestBodies.LoginBody(
            email = "eve.holt@reqres.in",
            password = "cityslicka"
        )
        viewModel.getLogin(body).observe(this, Observer { it ->
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
                            Toast.makeText(this, it.body()?.token, Toast.LENGTH_LONG).show()
                        }
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