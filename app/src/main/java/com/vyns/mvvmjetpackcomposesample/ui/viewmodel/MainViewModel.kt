package com.vyns.mvvmjetpackcomposesample.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vyns.mvvmjetpackcomposesample.data.model.MovieItem
import com.vyns.mvvmjetpackcomposesample.data.network.MovieApiClient
import com.vyns.mvvmjetpackcomposesample.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val apiService = MovieApiClient.service
    private lateinit var repository: MovieRepository
    var trendingMovies: List<MovieItem> by mutableStateOf(listOf())

    lateinit var clickedItem: MovieItem

    init {
        fetchTrendingMovies()
    }

    fun fetchTrendingMovies() {

        repository = MovieRepository(apiService)
        viewModelScope.launch {
            var response = repository.fetchTrendingMovies()
            when (response) {
                is MovieRepository.Result.Success -> {

                    Log.d("MainViewModel", "Success")
                    trendingMovies = response.movieList
                }
                is MovieRepository.Result.Failure -> {
                    Log.d("MainViewModel", "FAILURE")
                }
            }
        }
    }

    fun itemClicked(item: MovieItem) {
        clickedItem = item
    }
}