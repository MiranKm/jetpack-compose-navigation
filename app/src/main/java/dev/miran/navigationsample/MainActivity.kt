package dev.miran.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.miran.navigationsample.screens.actor.ActorDetailsScreen
import dev.miran.navigationsample.screens.details.DetailsScreen
import dev.miran.navigationsample.screens.home.HomeScreen
import dev.miran.navigationsample.screens.home.HomeViewModel
import dev.miran.navigationsample.ui.theme.NavigationSampleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: HomeViewModel = hiltViewModel()
            val navController = rememberNavController()

            NavigationSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(navController = navController, "home") {
                        composable("home") {
                            HomeScreen( viewModel, navController)
                        }

                        composable("details") {
                            DetailsScreen(viewModel, navController)
                        }

                        composable("actorDetails") {
                            ActorDetailsScreen(viewModel)
                        }
                    }
                }
            }
        }
    }
}
