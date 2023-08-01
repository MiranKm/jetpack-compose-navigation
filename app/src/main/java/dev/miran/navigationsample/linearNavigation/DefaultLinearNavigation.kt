package dev.miran.navigationsample.linearNavigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class DefaultLinearNavigationDelegate @Inject constructor() : LinearNavigationDelegate {
    private val _navigationState: MutableStateFlow<LinearNavigationState> =
        MutableStateFlow(LinearNavigationState.Idle)

    override val navigationState: StateFlow<LinearNavigationState> = _navigationState

    override fun onBack() {
        _navigationState.value = LinearNavigationState.Back
    }

    override fun onNext() {
        _navigationState.value = LinearNavigationState.Next
    }

    override fun resetNavigationState() {
        _navigationState.value = LinearNavigationState.Idle
    }
}