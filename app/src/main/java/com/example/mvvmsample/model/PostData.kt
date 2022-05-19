package com.example.mvvmsample.model

import com.google.gson.annotations.SerializedName

data class PostData (
    @SerializedName("id"             ) var id             : Int?    = null,
    @SerializedName("name"           ) var name           : String? = null,
    @SerializedName("email"          ) var email          : String? = null,
    @SerializedName("profilepicture" ) var profilepicture : String? = null,
    @SerializedName("location"       ) var location       : String? = null,
    @SerializedName("createdat"      ) var createdat      : String? = null

)