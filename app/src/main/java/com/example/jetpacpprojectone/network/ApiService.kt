package com.example.jetpacpprojectone.network

import com.example.jetpacpprojectone.Constants.Constant
import com.example.jetpacpprojectone.Constants.Constant.Companion.BASE_URL
import com.example.jetpacpprojectone.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET("movielist.json")
    suspend fun getMovies():List<Movie>

    companion object{
        var apiService:ApiService? = null
        fun getInstance(): ApiService{
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}