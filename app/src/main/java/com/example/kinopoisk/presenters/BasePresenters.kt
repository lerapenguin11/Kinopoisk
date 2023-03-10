package com.example.kinopoisk.presenters

import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenters<T : MvpView> : MvpPresenter<T>() {

    abstract fun enable()
}