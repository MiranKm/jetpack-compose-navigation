package dev.miran.navigationsample.linearNavigation

sealed interface LayerdNavigationState {
    object Idle : LayerdNavigationState
    data class Back(val route:String) : LayerdNavigationState
    data class Next(val route:String) : LayerdNavigationState
}