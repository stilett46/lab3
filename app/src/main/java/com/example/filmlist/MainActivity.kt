package com.example.filmlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.filmlist.data.Datasource
import com.example.filmlist.ui.FilmListViewModel
import com.example.filmlist.ui.theme.FilmListTheme

enum class FilmListScreen() {
    Start,
    Description
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FilmListApp()
                }
            }
        }
    }
}

@Composable
fun FilmListApp(
    filmListViewModel: FilmListViewModel = viewModel()
) {
    val filmListUiState by filmListViewModel.uiState.collectAsState()
    val navController = rememberNavController()

    val filmList = Datasource().loadFilms()
    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        NavHost(
            navController = navController,
            startDestination = FilmListScreen.Start.name
        ) {
            composable(route = FilmListScreen.Start.name) {
                FilmListStartScreen(
                    filmList = filmList,
                    onDescriptionButtonClicked = {
                        filmListViewModel.updateChoosedFilm(it)
                        navController.navigate(FilmListScreen.Description.name)
                    }
                )
            }
            composable(route = FilmListScreen.Description.name) {
                FilmDescriptionScreen(
                    film = filmList[filmListUiState.choosedFilm],
                    onBackButtonClicked = {
                        navController.popBackStack(FilmListScreen.Start.name, inclusive = false)
                    }
                )
            }
        }
    }
}