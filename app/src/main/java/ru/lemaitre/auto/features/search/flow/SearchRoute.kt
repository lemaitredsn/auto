package ru.lemaitre.auto.features.search.flow

sealed class SearchRoute {
    object SearchMainScreen: SearchRoute()
    object ModelCarDialog: SearchRoute()
}
