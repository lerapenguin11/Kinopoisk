package com.example.kinopoisk.business.repos

import android.annotation.SuppressLint
import android.util.Log
import com.example.kinopoisk.business.TEST.Callback
import com.example.kinopoisk.business.TEST.RetrofitClient
import com.example.kinopoisk.business.api.ApiProvider
import com.example.kinopoisk.business.api.MoviesApi
import com.example.kinopoisk.business.model.Doc
import com.example.kinopoisk.business.model.TEST
import com.example.kinopoisk.business.modelView.Movies
import com.example.kinopoisk.business.modelView.MoviesModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeRepository(api : ApiProvider) : BaseRepository<HomeRepository.ServerResponse>(api)  {

    @SuppressLint("CheckResult")
    fun reloadData(callback: Callback<List<Doc>>) {

        api.providerMoviesApi().getNewsMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<TEST>(){
                override fun onNext(t: TEST) {
                    callback.returnResult(t.docs)
                    println("HOME_REPOSITORY" + callback.returnResult(t.docs))
                }

                override fun onError(e: Throwable) {
                    Log.d("MAIN_REPO", "error: $e")
                }

                override fun onComplete() {

                }

            })
    }

    @SuppressLint("CheckResult")
    fun reloadDataPopular(callback: Callback<List<Doc>>) {

        api.providerMoviesApi().getMoviesPopular()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<TEST>(){
                override fun onNext(t: TEST) {
                    callback.returnResult(t.docs)
                    println("HOME_REPOSITORY" + callback.returnResult(t.docs))
                }

                override fun onError(e: Throwable) {
                    Log.d("MAIN_REPO", "error: $e")
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


