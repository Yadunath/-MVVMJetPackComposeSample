package com.vyns.mvvmjetpackcomposesample.data.network

import com.vyns.mvvmjetpackcomposesample.data.model.MovieResponse
import retrofit2.http.GET

interface MovieFetchApi {

    @GET("trending/all/day?api_key=57ec817a04be27f196d3da087d6b1a28")
    suspend fun fetchTrendingMovieList() : MovieResponse
}