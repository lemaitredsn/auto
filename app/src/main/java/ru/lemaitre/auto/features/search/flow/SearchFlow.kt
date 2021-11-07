package ru.lemaitre.auto.features.search.flow

import android.util.Log
import io.reactivex.subjects.BehaviorSubject

object SearchFlow {

    private val onNavigationIn = BehaviorSubject.create<SearchRoute>()

    init {
        onNavigationIn.onNext(SearchRoute.SearchMainScreen)
    }

    fun navigation() = onNavigationIn

    fun navigateMain() = onNavigationIn.onNext(SearchRoute.SearchMainScreen)
    fun navigateModelCar()  {
        Log.e("TAG", "navigateModelCar")
        onNavigationIn.onNext(SearchRoute.ModelCarDialog) }

}