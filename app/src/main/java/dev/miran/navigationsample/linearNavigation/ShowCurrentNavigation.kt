package dev.miran.navigationsample.linearNavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.repeatOnLifecycle

@Composable
fun ShowCurrentNavigation(
    viewModel: LinearNavigationDelegate,
    onNext: () -> Unit = {},
    onBack: () -> Unit = {},
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val currentOnBack by rememberUpdatedState(onBack)
    val currentOnNext by rememberUpdatedState(onNext)

    LaunchedEffect(viewModel, lifecycle) {
        viewModel.navigationState.flowWithLifecycle(lifecycle).collect { homeNavigationState ->
            when (homeNavigationState) {
                LinearNavigationState.Next -> {
                    currentOnNext()
                    viewModel.resetNavigationState()
                }
                LinearNavigationState.Back -> {
                    currentOnBack()
                    viewModel.resetNavigationState()
                }
                else -> {
                }
            }
        }
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.resetNavigationState()
        }
    }
}


@Composable
fun  LayerdShowCurrentNavigation(
    viewModel: LayerdNavigationDelegate,
    onNext: (String) -> Unit = {},
    onBack: (String) -> Unit = {},
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val currentOnBack by rememberUpdatedState(onBack)
    val currentOnNext by rememberUpdatedState(onNext)

    LaunchedEffect(viewModel, lifecycle) {
        viewModel.layerdNavigationState.flowWithLifecycle(lifecycle).collect { homeNavigationState ->
            when (homeNavigationState) {
                is LayerdNavigationState.Next -> {
                    currentOnNext(homeNavigationState.route)
                    viewModel.reset()
                }
                is LayerdNavigationState.Back -> {
                    currentOnBack(homeNavigationState.route)
                    viewModel.reset()
                }
                else -> {
                }
            }
        }
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.reset()
        }
    }
}

