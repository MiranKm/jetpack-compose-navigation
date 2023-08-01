package dev.miran.navigationsample.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.miran.navigationsample.linearNavigation.DefaultLayerdNavigationDelegate
import dev.miran.navigationsample.linearNavigation.DefaultLinearNavigationDelegate
import dev.miran.navigationsample.linearNavigation.LayerdNavigationDelegate
import dev.miran.navigationsample.linearNavigation.LinearNavigationDelegate
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(),
    LinearNavigationDelegate by DefaultLinearNavigationDelegate(),
    LayerdNavigationDelegate by DefaultLayerdNavigationDelegate() {

    fun navigateInSeconds(ms: Long) {
        viewModelScope.launch {
            delay(ms)
            onNext()
        }
    }

    fun navigateInSecondsToRoute(ms: Long, route: String) {
        viewModelScope.launch {
            onNext(route)
        }
    }

}