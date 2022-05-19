package com.example.mvvmsample.model

import com.google.gson.annotations.SerializedName

data class PostResponse (
    @SerializedName("page"        ) var page        : Int?            = null,
    @SerializedName("per_page"    ) var perPage     : Int?            = null,
    @SerializedName("totalrecord" ) var totalrecord : Int?            = null,
    @SerializedName("total_pages" ) var totalPages  : Int?            = null,
    @SerializedName("data"        ) var data        : ArrayList<PostData> = arrayListOf()

)