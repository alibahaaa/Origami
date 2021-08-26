package ali.baha.origami.app.navigation

import ali.baha.origami.app.routers.Screen
import ali.baha.origami.detail.DetailScreen
import ali.baha.origami.home.ui.HomeScreen
import ali.baha.origami.menu.MenuScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                origamiHomeViewModel = hiltViewModel()
            )
        }

        composable(route = Screen.MenuScreen.route) {
            MenuScreen(navController = navController)
        }

        composable(
            route = Screen.DetailScreen.route + "/{name}/{image}/{description}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "name"
                    nullable = false
                },
                navArgument("image") {
                    type = NavType.StringType
                    defaultValue = "image"
                    nullable = false
                },
                navArgument("description") {
                    type = NavType.StringType
                    defaultValue = "description"
                    nullable = false
                }
            )
        ) { entry ->
            DetailScreen(
                navController = navController,
                name = entry.arguments?.getString("name"),
                image = entry.arguments?.getString("image"),
                description = entry.arguments?.getString("description")
            )
        }
    }
}