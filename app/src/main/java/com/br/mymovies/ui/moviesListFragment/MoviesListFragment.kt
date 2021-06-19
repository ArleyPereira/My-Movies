package com.br.mymovies.ui.moviesListFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.br.mymovies.R
import com.br.mymovies.data.DatabaseApi

class MoviesListFragment : Fragment(R.layout.movies_list_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllMovies()
    }

    private fun getAllMovies(){

        DatabaseApi().getAllMovies({ movies ->
            Log.i("INFOTESTE", "getAllMovies: $movies")
        },{ error ->
            Log.i("INFOTESTE", "getAllMovies: ${error.message}")
        })

    }

}