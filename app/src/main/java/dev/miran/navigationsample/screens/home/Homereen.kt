package dev.miran.navigationsample.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.miran.navigationsample.linearNavigation.LayerdShowCurrentNavigation
import dev.miran.navigationsample.ui.theme.NavigationSampleTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(vm: HomeViewModel, navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Hey ;)") })
        }
    ) {
        Column {

            Text(text = "Hello from home screen!")

            Button(onClick = {

                vm.navigateInSecondsToRoute(2000, "actorDetails")
            }) {
                Text("Navigate to actor details")
            }

            Button(onClick = {
                vm.onNext("details")
            }) {
                Text("Navigate to  details")
            }


            LayerdShowCurrentNavigation(vm, onNext = {
                navController.navigate(it)
            }, onBack = {

            })

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationSampleTheme {
        HomeScreen(hiltViewModel(), rememberNavController())
    }
}
