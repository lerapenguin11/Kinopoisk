package com.example.kinopoisk.business.model

data class TEST(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int,

    val genres: List<Genre>
)