package ru.lemaitre.auto.features.search.search.di

import dagger.Component
import ru.lemaitre.auto.features.search.all.AllFragment
import ru.lemaitre.auto.features.search.flow.SearchFlowFragment
import ru.lemaitre.auto.features.search.search.SearchFragment
import javax.inject.Singleton

@Component(
    modules = [SearchModule::class]
)
@FragmentScope
interface SearchComponent {
    fun inject(fragment: SearchFlowFragment)
    fun inject(fragment: AllFragment)
}