package com.example.kinopoisk.business.model

data class Rating(
    val await: Int,
    val filmCritics: Int,
    val imdb: Double,
    val kp: Double,
    val russianFilmCritics: Int
)