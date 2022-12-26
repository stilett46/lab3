package com.example.filmlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.filmlist.model.Film

@Composable
fun FilmDescriptionScreen(film: Film, onBackButtonClicked: () -> Unit) {
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
            style = MaterialTheme.typography.h2
        )
        Text(
            text = stringResource(film.descriptionResouceId),
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.h6
        )
        Button(
            onClick = onBackButtonClicked,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Повернутися",
                color = Color.White
            )
        }
    }
}