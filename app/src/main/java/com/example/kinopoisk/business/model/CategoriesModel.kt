package com.example.kinopoisk.business.model

data class CategoriesModel(
    val ageRating: Int,
    val alternativeName: String,
    val backdrop: Backdrop,
    val budget: Budget,
    val countries: List<Country>,
    val description: String,
    val distributors: Distributors,
    val enName: Any,
    val externalId: ExternalId,
    val facts: List<Fact>,
    val fees: Fees,
    val genres: List<Genre>,
    val id: Int,
    val images: Images,
    val lists: List<Any>,
    val logo: Logo,
    val movieLength: Int,
    val name: String,
    val names: List<Name>,
    val persons: List<Person>,
    val poster: Poster,
    val premiere: Premiere,
    val productionCompanies: List<Any>,
    val rating: Rating,
    val ratingMpaa: Any,
    val releaseYears: List<ReleaseYear>,
    val seasonsInfo: List<SeasonsInfo>,
    val sequelsAndPrequels: List<SequelsAndPrequel>,
    val shortDescription: Any,
    val similarMovies: List<SimilarMovy>,
    val slogan: String,
    val spokenLanguages: List<Any>,
    val status: String,
    val technology: Technology,
    val ticketsOnSale: Boolean,
    val top10: Any,
    val top250: Any,
    val type: String,
    val typeNumber: Int,
    val updatedAt: String,
    val videos: Videos,
    val votes: Votes,
    val watchability: Watchability,
    val year: Int
)