package com.example.mvvmsample.model

import com.google.gson.annotations.SerializedName

data class LoggedInResponse (
    @SerializedName("code"    ) var code    : Int?    = null,
    @SerializedName("message" ) var message : String? = null,
    @SerializedName("data"    ) var data    : Data?   = Data()

)