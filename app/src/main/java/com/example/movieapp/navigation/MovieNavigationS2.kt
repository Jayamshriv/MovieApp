package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.details.DetailScreen
import com.example.movieapp.screens.home.HomeScreen


///////////////////////////// STEP 2 ///////////////////////////

@Composable
fun MovieNavigation() {

    ///////////////// STEP A///////////////////
    val navController = rememberNavController()

    //////////////// STEP B////////////////////
    NavHost(navController = navController, startDestination = MovieScreenS1.HomeScreen.name) {
        composable(MovieScreenS1.HomeScreen.name) {

            //////////////// STEP C////////////////////
            HomeScreen(navController = navController)

        }

        composable(
            MovieScreenS1.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {
                type = NavType.StringType
            })
        ) {

            DetailScreen(navController = navController, it.arguments?.getString("movie"))
        }

    }

}