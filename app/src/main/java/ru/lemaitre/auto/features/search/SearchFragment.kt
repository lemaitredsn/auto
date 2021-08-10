package ru.lemaitre.auto.features.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import ru.lemaitre.auto.R
import ru.lemaitre.auto.databinding.FragmentSearchBinding
import ru.lemaitre.auto.features.search.all.AllFragment
import ru.lemaitre.auto.features.search.b_u.BuFragment
import ru.lemaitre.auto.features.search.for_you.ForYouFragment
import ru.lemaitre.auto.features.search.new.NewFragment

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val fragment = when(tab?.text){
                    tab?.customView?.context?.getString(R.string.tab_all) -> AllFragment()
                    tab?.customView?.context?.getString(R.string.tab_bu) -> BuFragment()
                    tab?.customView?.context?.getString(R.string.tab_new) -> NewFragment()
                    tab?.customView?.context?.getString(R.string.tab_for_you) -> ForYouFragment()
                    else -> return
                }

                childFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commitNow()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
            override fun onTabReselected(tab: TabLayout.Tab?) = Unit

        })

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_all))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_bu))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_new))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_for_you))


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}