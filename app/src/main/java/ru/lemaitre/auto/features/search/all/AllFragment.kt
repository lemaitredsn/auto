package ru.lemaitre.auto.features.search.all

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import by.kirich1409.viewbindingdelegate.viewBinding
import com.squareup.moshi.Moshi
import ru.lemaitre.auto.R
import ru.lemaitre.auto.data.repository.MockData.generateFakeJson
import ru.lemaitre.auto.databinding.FragmentAllBinding
import ru.lemaitre.auto.data.model.AdsModel
import ru.lemaitre.auto.features.search.flow.SearchFlow
import ru.lemaitre.auto.features.search.search.di.DaggerSearchComponent
import java.lang.Exception
import javax.inject.Inject

class AllFragment : Fragment(R.layout.fragment_all), AllView {

    private val binding: FragmentAllBinding by viewBinding()

    @Inject
    lateinit var presenter: AllPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectDI()
        presenter.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonChooseModel.setOnClickListener {
            presenter.toModelDialog()
        }

        convertFakeJson()
    }

    private fun convertFakeJson(){
        val fakeJson = generateFakeJson()
        val converter = Moshi.Builder().build()
        val adapter = converter.adapter(AdsModel::class.java).nonNull()
        try {
            val ads = adapter.fromJson(fakeJson)
            Log.e("TAG", ads.toString())
        }catch (e: Exception){
            Log.e("TAG", e.localizedMessage)
        }
    }

    fun injectDI(){
        DaggerSearchComponent.builder()
            .build()
            .inject(this)
    }

    override fun nav() {
        //test
    }
}