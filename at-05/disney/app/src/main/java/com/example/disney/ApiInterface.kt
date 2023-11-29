package com.example.disney

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("character")
    fun getCharacters(
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): Call<CharacterResponse>
}
