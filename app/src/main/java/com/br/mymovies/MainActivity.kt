package com.br.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.br.mymovies.data.DatabaseApi

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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