package com.example.kinopoisk.business.TEST

abstract class Callback<T> {
    abstract fun returnResult(t: T)
    abstract fun returnError(error : Throwable)
}