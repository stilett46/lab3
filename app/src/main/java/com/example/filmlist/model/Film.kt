package com.example.filmlist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Film(
    @StringRes val nameResouceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val descriptionResouceId: Int,
    val id: Int
)