package com.example.kinopoisk.business.repos

import android.util.Log
import com.example.kinopoisk.business.TEST.Callback
import com.example.kinopoisk.business.api.ApiProvider
import com.example.kinopoisk.business.model.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class FilterRepository(api : ApiProvider) : BaseRepository<FilterRepository>(api){

    fun reloadDataGenre(callback: Callback<List<AllGenresItem>>) {
        api.providerMoviesApi().getListGenre()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<AllGenres>(){
                override fun onNext(t: AllGenres) {
                    callback.returnResult(t)
                    Log.d("FILTER_REPO", callback.returnResult(t).toString())
                }

                override fun onError(e: Throwable) {
                    Log.d("FILTER_REPO_GENRE", "error: $e")
                }

                override fun onComplete() {}
            })
    }

    fun reloadDataCountry(callback: Callback<List<AllCountriesItem>>){
        api.providerMoviesApi().getListCountry()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<AllCountries>(){
                override fun onNext(t: AllCountries) {
                    callback.returnResult(t)
                }

                override fun onError(e: Throwable) {
                    Log.d("FILTER_REPO_COUNTRY", "error: $e")
                }

                override fun onComplete() {

                }
            })
    }
}