package com.example.kinopoisk.business.modelView

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int?,

    @SerializedName("posterUrl")
    val posterUrl: String?,

    @SerializedName("nameRu")
    val nameRu: String?,

    @SerializedName("year")
    val year: Int

) : Parcelable{
    constructor() : this (0, "", "", 2022)
}

/*
data class Const(
    val completed: Boolean,
    val countries: List<Country>,
    val coverUrl: String,
    val description: String,
    val editorAnnotation: String,
    val endYear: Int,
    val filmLength: Int,
    val genres: List<Genre>,
    val has3D: Boolean,
    val hasImax: Boolean,
    val imdbId: String,
    val isTicketsAvailable: Boolean,
    val lastSync: String,
    val logoUrl: String,
    val nameEn: String,
    val nameOriginal: String,
    val posterUrlPreview: String,
    val productionStatus: String,
    val ratingAgeLimits: String,
    val ratingAwait: Double,
    val ratingAwaitCount: Int,
    val ratingFilmCritics: Double,
    val ratingFilmCriticsVoteCount: Int,
    val ratingGoodReview: Double,
    val ratingGoodReviewVoteCount: Int,
    val ratingImdb: Double,
    val ratingImdbVoteCount: Int,
    val ratingKinopoisk: Double,
    val ratingKinopoiskVoteCount: Int,
    val ratingMpaa: String,
    val ratingRfCritics: Double,
    val ratingRfCriticsVoteCount: Int,
    val reviewsCount: Int,
    val serial: Boolean,
    val shortDescription: String,
    val shortFilm: Boolean,
    val slogan: String,
    val startYear: Int,
    val type: String,
    val webUrl: String,

)
*/
