package dev.miran.navigationsample.linearNavigation

import kotlinx.coroutines.flow.StateFlow

interface LinearNavigationDelegate: NavigationDelegate {
    val navigationState: StateFlow<LinearNavigationState>
    fun onBackSelected()
    fun onNextSelected()
    fun resetNavigationState()
}