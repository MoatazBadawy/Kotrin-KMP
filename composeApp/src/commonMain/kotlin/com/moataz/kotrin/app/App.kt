package com.moataz.kotrin.app

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.moataz.kotrin.features.home.ui.HomeScreen
import com.moataz.kotrin.features.imageView.ImageScreen
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Serializable
object HomeDestination

@Serializable
data class ImageDestination(val objectUrl: String)

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface {
            val navController: NavHostController = rememberNavController()
            NavHost(navController = navController, startDestination = HomeDestination) {
                composable<HomeDestination> {
                    HomeScreen(navigateToImages = { objectUrl ->
                        navController.navigate(ImageDestination(objectUrl))
                    })
                }
                composable<ImageDestination> { backStackEntry ->
                    ImageScreen(
                        objectUrl = backStackEntry.toRoute<ImageDestination>().objectUrl
                    )
                }
            }
        }
    }
}