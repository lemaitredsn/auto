package ru.lemaitre.auto.features.search.flow

import android.annotation.SuppressLint
import android.util.Log
import javax.inject.Inject

class SearchFlowPresenter @Inject constructor(
    private val flow: SearchFlow
): BasePresenter {


    override fun onFirstAttach(view: SearchFlowView) {
        Log.e("TAG", "$flow" )
        flow.navigation()
            .subscribe(
                {
                    Log.e("TAG", "subscribe $it")
                    view.navigate(it)
                }, { Log.e("TAG", "catch error in flow seach ${it.message}") })
    }
}