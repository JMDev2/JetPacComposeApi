package com.example.jetpacpprojectone.viewomdel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpacpprojectone.model.Movie
import com.example.jetpacpprojectone.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel(){
    var movieListResponse: List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")


    fun getMovielist(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try {
                val movieList = apiService.getMovies()
                movieListResponse = movieList
            }

            catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}