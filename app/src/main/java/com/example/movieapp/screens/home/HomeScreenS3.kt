package com.example.movieapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.widgets.MovieItem
import com.example.movieapp.model.DataManager
import com.example.movieapp.model.Movie
import com.example.movieapp.navigation.MovieScreenS1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(imageVector = Icons.Default.ExitToApp, contentDescription = "")
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "Movies")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFC96666)
                )

            )
        }) {
        Surface(Modifier.padding(it)) {
            MainContent(navController, DataManager.data)
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movies: Array<Movie>
) {
    LazyColumn(content = {
        items(items = movies) {
            MovieItem(it) {movieName->
                navController.navigate(route = MovieScreenS1.DetailScreen.name+"/$movieName")
            }
        }
    })
}