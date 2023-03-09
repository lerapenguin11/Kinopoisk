package com.example.kinopoisk.business.model

data class Votes(
    val await: Int,
    val filmCritics: Int,
    val imdb: Int,
    val kp: Int,
    val russianFilmCritics: Int
)