package com.example.mvvmsample

import android.os.Bundle
import androidx.core.content.ContextCompat

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setScreenTitle(R.string.app_name)
        getBackButton().setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_back
            )
        )
        getBackButton().setOnClickListener {
            finish()
        }
    }
}
