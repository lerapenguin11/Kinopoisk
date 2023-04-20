package com.example.kinopoisk.business.repos

import android.annotation.SuppressLint
import com.example.kinopoisk.business.TEST.Callback
import com.example.kinopoisk.business.TEST.RetrofitClient
import com.example.kinopoisk.business.api.ApiProvider
import com.example.kinopoisk.business.api.MoviesApi
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

const val TAG = "HOME_REPO"

class HomeRepository(api : ApiProvider) : BaseRepository<HomeRepository.ServerResponse>(api)  {

    @SuppressLint("CheckResult")
    fun reloadData(callback : Callback<List<Movies>>) {

        api.providerMoviesApi().getPopularMovie2()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<List<Movies>>(){
                override fun onNext(movies: List<Movies>) {
                    callback.returnResult(movies)
                    println("HOME_REPOSITORY" + callback.returnResult(movies))
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }

            })
    }

    data class ServerResponse(
        val name: String,
        val newMovies: List<Movies>,
        val error: Throwable? = null)
}



