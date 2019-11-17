package com.alfanshter.loginbaru.Model

import com.google.gson.annotations.SerializedName

data class  DataClass(
    @SerializedName("value")
    val value:String?=null,

    @field:SerializedName("result")
    val resultData: List<ResultItemData?>? = null


)