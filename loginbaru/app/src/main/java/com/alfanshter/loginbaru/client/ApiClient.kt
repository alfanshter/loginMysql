package com.alfanshter.loginbaru.client

import com.alfanshter.loginbaru.Model.DataClass
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiClient {
    @FormUrlEncoded
    @POST("register.php")
    fun registerUser (
        @Field("username")username:String,
        @Field("password")password:String
        ): Call<DataClass>

    @FormUrlEncoded
    @POST("login.php")
    fun login (
        @Field("username")username:String,
        @Field("password")password:String
    ): Call<DataClass>

    @FormUrlEncoded
    @POST("jenis.php")
    fun jenisbarang (
        @Field("namajenis")jenisbarang:String,
        @Field("iduser")iduser:String
    ): Call<DataClass>

    @FormUrlEncoded
    @POST("insert_barang.php")
    fun insertbarang (
        @Field("nama")nama:String,
        @Field("quantity")quantity:String,
        @Field("harga")harga:String,
        @Field("jenis")jenis:String
        ): Call<DataClass>

    @Multipart
    @POST("upload_image_reports.php")
    fun uploadFile(@Part file: MultipartBody.Part, @Part("name") name: RequestBody): Call<DataClass>


    @FormUrlEncoded
    @POST("tampil_tbjenis.php")
    fun tampiltbjenis (
        @Field("iduser")iduser:String
    ): Call<DataClass>

    @GET("tampilall.php")
    fun tampilall(

    ): Call<DataClass>



}
