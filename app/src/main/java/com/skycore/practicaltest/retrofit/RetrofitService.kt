package com.skycore.practicaltest.retrofit

import com.skycore.practicaltest.model.ResponseRestaurant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {

    @GET("search")
    suspend fun getBusinessesList(
        @Header("Authorization") authorization:String,
        @Header("accept") accept:String,
        @Query("term") term: String,
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("sort_by") sort_by: String,
        @Query("limit") limit: Int,
    ): Response<ResponseRestaurant>

}