package com.example.mvvmsample.model

import com.google.gson.annotations.SerializedName


data class Data (
  @SerializedName("Id"    ) var Id    : Int?    = null,
  @SerializedName("Name"  ) var Name  : String? = null,
  @SerializedName("Email" ) var Email : String? = null,
  @SerializedName("Token" ) var Token : String? = null
)