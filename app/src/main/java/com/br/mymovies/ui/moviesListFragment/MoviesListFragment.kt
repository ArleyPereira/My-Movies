package com.br.mymovies.ui.moviesListFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.br.mymovies.R
import kotlinx.android.synthetic.main.movies_list_fragment.*

class MoviesListFragment : Fragment(R.layout.movies_list_fragment) {

    private val viewModel = MoviesListViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observerViewModelEvents()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllMovies()
    }

    private fun observerViewModelEvents(){
        viewModel.allMoviesEvent.observe(viewLifecycleOwner) { allMovies ->
            val movieAdapter = MovieAdapter(allMovies)
            with(rvMovies){
                layoutManager = GridLayoutManager(requireContext(), 2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}