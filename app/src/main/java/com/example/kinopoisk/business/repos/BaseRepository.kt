package com.example.kinopoisk.business.repos

import com.example.kinopoisk.business.api.ApiProvider
import io.reactivex.rxjava3.subjects.BehaviorSubject

abstract class BaseRepository<T>(var api : ApiProvider) {

    val dataEmitter : BehaviorSubject<T> = BehaviorSubject.create()
}