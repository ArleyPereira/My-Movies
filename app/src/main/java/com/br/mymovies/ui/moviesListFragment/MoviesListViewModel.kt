package com.br.mymovies.ui.moviesListFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.mymovies.data.entity.Movie
import com.br.mymovies.repository.MovieRepository

class MoviesListViewModel: ViewModel() {

    private val _allMoviesEvent = MutableLiveData<List<Movie>>()
    val allMoviesEvent: LiveData<List<Movie>>
        get() = _allMoviesEvent

    fun getAllMovies() = MovieRepository.getAllMovies({ movies ->
        _allMoviesEvent.value = movies
    }, {
        _allMoviesEvent.value = listOf()
    })

}