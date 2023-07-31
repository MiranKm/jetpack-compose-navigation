package dev.miran.navigationsample.linearNavigation

import kotlinx.coroutines.flow.StateFlow

interface LayerdNavigationDelegate: NavigationDelegate {
    val layerdNavigationState: StateFlow<LayerdNavigationState>
    fun onBackSelected(route:String)
    fun onNextSelected(route:String)
    fun reset()
}