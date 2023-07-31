package dev.miran.navigationsample.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import dev.miran.navigationsample.linearNavigation.ShowCurrentNavigation
import dev.miran.navigationsample.screens.home.HomeViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(viewModel: HomeViewModel, navController: NavController) {

    val navState by viewModel.layerdNavigationState.collectAsState()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text("Details Screen")
        })
    }) {
        Column {
            Text("Hey from the detz")
            Text("Navigation State:: $navState")
            TextButton(onClick = {
                viewModel.navigateInSeconds(2000)
            }) {
                Text("Navigate to Actor details")
            }
        }
    }

    ShowCurrentNavigation(viewModel, onNext = {
        navController.navigate("actorDetails")
    }, onBack = {

    })
}