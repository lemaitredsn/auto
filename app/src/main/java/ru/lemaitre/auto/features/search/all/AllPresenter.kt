package ru.lemaitre.auto.features.search.all

import android.util.Log
import ru.lemaitre.auto.features.search.flow.SearchFlow
import javax.inject.Inject

class AllPresenter @Inject constructor(
    private val flow: SearchFlow
) {
    fun attachView(view: AllView){
        view.nav()
    }

    fun toModelDialog(){
        Log.e("TAG", "$flow" )
        flow.navigateModelCar()
    }
}