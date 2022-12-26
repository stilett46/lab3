package com.example.filmlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.filmlist.model.Film
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.filmlist.ui.FilmListViewModel

@Composable
fun FilmListStartScreen(
    filmList: List<Film>,
    onDescriptionButtonClicked: (Int) -> Unit
) {
    LazyColumn {
        items(filmList) { film ->
            FilmCard(film, onDescriptionButtonClicked)
        }
    }
}

@Composable
fun FilmCard(
    film: Film,
    onDescriptionButtonClicked: (Int) -> Unit
) {
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Column {
            Image(
                painter = painterResource(film.imageResourceId),
                contentDescription = stringResource(film.nameResouceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(film.nameResouceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
            Button(
                onClick = {
                    onDescriptionButtonClicked(film.id)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Детальнiше",
                    color = Color.White
                )
            }
        }
    }
}