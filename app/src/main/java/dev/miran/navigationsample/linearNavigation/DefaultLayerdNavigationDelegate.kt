package dev.miran.navigationsample.linearNavigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class DefaultLayerdNavigationDelegate @Inject constructor() : LayerdNavigationDelegate {

    private val _navigationState: MutableStateFlow<LayerdNavigationState> =
        MutableStateFlow(LayerdNavigationState.Idle)
    override val layerdNavigationState: StateFlow<LayerdNavigationState> = _navigationState

    override fun onBackSelected(route:String) {
        _navigationState.value = LayerdNavigationState.Back(route)
    }

    override fun onNextSelected(route:String) {
        _navigationState.value = LayerdNavigationState.Next(route)
    }

    override fun reset() {
        _navigationState.value = LayerdNavigationState.Idle
    }
}