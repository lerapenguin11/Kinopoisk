package com.example.kinopoisk.business.model

data class Doc(
    val alternativeName: String,
    val color: String,
    val countries: List<Country>,
    val description: String,
    val enName: Any,
    val externalId: ExternalId,
    val genres: List<Genre>,
    val id: Int,
    val logo: Logo,
    val movieLength: Int,
    val name: String,
    val names: List<Name>,
    val poster: Poster,
    val rating: Rating,
    val shortDescription: String,
    val type: String,
    val votes: Votes,
    val watchability: Watchability,
    val year: Int
)