package com.alfanshter.loginbaru.Model

import com.google.gson.annotations.SerializedName

data class ResultItemData(

	@field:SerializedName("iduser")
	val iduser: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("password")
	val password: String? = null,


	@field:SerializedName("namajenis")
	val namajenis: String? = null,

    @field:SerializedName("quantity")
    val quantity: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("harga")
    val harga: String? = null,

    @field:SerializedName("jenis")
    val jenis: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("gambar")
    val gambar: String? = null

)