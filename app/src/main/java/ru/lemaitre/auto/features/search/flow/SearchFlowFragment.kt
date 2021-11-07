package ru.lemaitre.auto.features.search.flow

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.lemaitre.auto.R
import ru.lemaitre.auto.features.search.search.di.DaggerSearchComponent
import javax.inject.Inject

class SearchFlowFragment : Fragment(), SearchFlowView {

    @Inject
    lateinit var presenter: SearchFlowPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDI()
        presenter.onFirstAttach(this)
    }

    @SuppressLint("RestrictedApi")
    override fun navigate(search: SearchRoute) {
        Log.e("TAG", "SearchMainScreen $search name ${findNavController().currentDestination}")

        when(search){
            SearchRoute.SearchMainScreen -> {
                Log.e("TAG", "SearchMainScreen catch")
                findNavController().navigate(R.id.searchFragment)
            }
            SearchRoute.ModelCarDialog -> {
                Log.e("TAG", "model dialog catch")
                findNavController().navigate(R.id.modelCarDialogFragment)
            }
            else -> {}
        }
    }

    fun injectDI(){
        DaggerSearchComponent.builder()
            .build()
            .inject(this)
    }

}