package com.example.kinopoisk.business.model

data class Rating(
    val await: Any,
    val filmCritics: Double,
    val imdb: Double,
    val kp: Double,
    val russianFilmCritics: Double
)