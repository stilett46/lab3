package com.example.filmlist.ui

import androidx.lifecycle.ViewModel
import com.example.filmlist.FilmListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FilmListViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(FilmListUiState())
    val uiState: StateFlow<FilmListUiState> = _uiState.asStateFlow()

    fun updateChoosedFilm(id: Int) {
        _uiState.update { currentState ->
            currentState.copy(choosedFilm = id)
        }
    }
}