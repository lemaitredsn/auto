package ru.lemaitre.auto.features.search.search

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import ru.lemaitre.auto.R
import ru.lemaitre.auto.databinding.FragmentSearchBinding
import ru.lemaitre.auto.features.search.all.AllFragment
import ru.lemaitre.auto.features.search.used_car.BuFragment
import ru.lemaitre.auto.features.search.for_you.ForYouFragment
import ru.lemaitre.auto.features.search.new_car.NewFragment
import ru.lemaitre.auto.features.search.search.di.DaggerSearchComponent
import javax.inject.Inject

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding: FragmentSearchBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val fragment = when (tab?.text) {
                    ALL_FRAGMENT -> AllFragment()
                    BU_FRAGMENT -> BuFragment()
                    NEW_FRAGMENT -> NewFragment()
                    FOR_YOU_FRAGMENT -> ForYouFragment()
                    else -> return
                }

                childFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
            override fun onTabReselected(tab: TabLayout.Tab?) = Unit

        })

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(ALL_FRAGMENT))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(BU_FRAGMENT))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(NEW_FRAGMENT))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(FOR_YOU_FRAGMENT))


    }


    companion object {
        const val ALL_FRAGMENT = "Все"
        const val BU_FRAGMENT = "Б\\у"
        const val NEW_FRAGMENT = "Новые"
        const val FOR_YOU_FRAGMENT = "Для Вас"
    }

}