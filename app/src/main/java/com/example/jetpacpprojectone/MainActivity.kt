package com.example.jetpacpprojectone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpacpprojectone.model.Movie
import com.example.jetpacpprojectone.ui.theme.JetpacpProjectOneTheme
import com.example.jetpacpprojectone.view.MovieItem
import com.example.jetpacpprojectone.viewomdel.MovieViewModel

class MainActivity : ComponentActivity() {

    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpacpProjectOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MovieList(movieList = movieViewModel.movieListResponse)
                    movieViewModel.getMovielist()
                }
            }
        }
    }
}

@Preview
@Composable
fun MovieList(movieList: List<Movie>){
    LazyColumn{
        itemsIndexed(items = movieList){index, item ->
            MovieItem(movie = item)
            
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpacpProjectOneTheme {
        val movie = Movie("maina", "", "maina is god","name")
        MovieItem(movie = movie)
    }
}