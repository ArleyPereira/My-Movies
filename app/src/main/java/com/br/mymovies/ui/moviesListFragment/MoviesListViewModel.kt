package com.br.mymovies.ui.moviesListFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.mymovies.data.entity.Movie
import com.br.mymovies.repository.MovieRepository
import com.br.mymovies.repository.MoviesAllRepository

class MoviesListViewModel: ViewModel() {

    init {
        getDetailsMovie()
    }

    private val _allMoviesEvent = MutableLiveData<List<Movie>>()
    val allMoviesEvent: LiveData<List<Movie>>
        get() = _allMoviesEvent

    fun getAllMovies() = MoviesAllRepository().getAllMovies({ movies ->
        _allMoviesEvent.value = movies
    }, {
        _allMoviesEvent.value = listOf()
    })

    fun getDetailsMovie() = MovieRepository().getDetailsMovie({ movie ->
        Log.i("INFOTESTE", "getDetailsMovie: $movie")
    }, {

    })

}