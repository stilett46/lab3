package com.example.filmlist.data

import com.example.filmlist.R
import com.example.filmlist.model.Film

class Datasource {
    fun loadFilms(): List<Film> {
        return listOf<Film>(
            Film(R.string.film1, R.drawable.film1, R.string.film1_desc, 0),
            Film(R.string.film2, R.drawable.film2, R.string.film2_desc, 1),
            Film(R.string.film3, R.drawable.film3, R.string.film3_desc, 2),
            Film(R.string.film4, R.drawable.film4, R.string.film4_desc, 3),
            Film(R.string.film5, R.drawable.film5, R.string.film5_desc, 4),
            Film(R.string.film6, R.drawable.film6, R.string.film6_desc, 5),
            Film(R.string.film7, R.drawable.film7, R.string.film7_desc, 6),
        )
    }
}