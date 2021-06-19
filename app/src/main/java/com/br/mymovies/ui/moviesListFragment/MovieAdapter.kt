package com.br.mymovies.ui.moviesListFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.mymovies.R
import com.br.mymovies.data.entity.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindView(movies[position])
    }

    override fun getItemCount() = movies.count()

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie);
        private val textTitleMovie: TextView = itemView.findViewById(R.id.textTitleMovie)

        fun bindView(movie: Movie){
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.poster).into(imgMovie)
            textTitleMovie.text = movie.title
        }

    }

}