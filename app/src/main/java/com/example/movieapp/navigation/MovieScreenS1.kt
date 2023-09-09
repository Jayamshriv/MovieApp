package com.example.movieapp.navigation



////////////////////////////////////   NAVIGATION STEP1 ////////////////////////////////
enum class MovieScreenS1 {
    HomeScreen,
    DetailScreen;
    companion object{
        fun fromRoute(route: String?) : MovieScreenS1 =
            when(route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else-> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}