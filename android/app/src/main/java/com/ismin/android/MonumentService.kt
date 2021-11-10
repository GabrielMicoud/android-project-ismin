package com.ismin.android

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface MonumentService {

    @GET("monuments")
    fun getAllMonuments(@Query("imei") imei : String): Call<List<Monument>>

    @PUT("monuments/{objectid}")
    fun favMonument(@Path("objectid") objectid : String, @Query("imei") imei : String): Call<Monument>

    @GET("monuments/{objectid}")
    fun getMonument(@Path("objectid") objectid : String, @Query("imei") imei : String): Call<Monument>

}