package dev.miran.navigationsample.linearNavigation

sealed interface LinearNavigationState {
    object Idle : LinearNavigationState
    object Back : LinearNavigationState
    object Next : LinearNavigationState
}