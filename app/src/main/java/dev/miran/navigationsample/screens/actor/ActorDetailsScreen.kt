package dev.miran.navigationsample.screens.actor

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.miran.navigationsample.screens.home.HomeViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ActorDetailsScreen(viewModel: HomeViewModel) {

    val navState by viewModel.layerdNavigationState.collectAsState()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text("Actor Details Screen")
        })
    }) {
        Column{
            Text("Hey from the actors page")
            Text("Navigation State:: $navState")
        }
    }
}