package com.example.kinopoisk.business.repos

import com.example.kinopoisk.business.api.ApiProvider
import io.reactivex.rxjava3.subjects.BehaviorSubject

abstract class BaseRepository<T>(val api : ApiProvider) {

    val dataEmitter : BehaviorSubject<T> = BehaviorSubject.create()
}