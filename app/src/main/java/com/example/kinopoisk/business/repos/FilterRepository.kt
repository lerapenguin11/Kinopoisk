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
                    Log.d("FILTER_REPO", "error: $e")
                }

                override fun onComplete() {}
            })
    }
}