package dev.miran.navigationsample.linearNavigation

import kotlinx.coroutines.flow.StateFlow

interface LayerdNavigationDelegate: NavigationDelegate {
    val layerdNavigationState: StateFlow<LayerdNavigationState>
    fun onBack(route:String)
    fun onNext(route:String)
    fun reset()
}