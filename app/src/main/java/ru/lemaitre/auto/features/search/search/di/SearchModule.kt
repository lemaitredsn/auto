package ru.lemaitre.auto.features.search.search.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.lemaitre.auto.features.search.flow.SearchFlow
import javax.inject.Singleton

@Module
class SearchModule {

    @Provides
    @FragmentScope
    fun provideFlow() = SearchFlow
}