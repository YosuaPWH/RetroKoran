package com.yosuahaloho.retrokoran.ui.page.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yosuahaloho.retrokoran.domain.model.Article
import com.yosuahaloho.retrokoran.domain.repository.NewsRepository
import com.yosuahaloho.retrokoran.util.Result
import com.yosuahaloho.retrokoran.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Yosua on 13/05/2023
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepo: NewsRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<Article>>> =
        MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<List<Article>>> get() = _uiState

    fun getHeadlineNews(country: String) {
        viewModelScope.launch {
            newsRepo.getHeadlineNews(country).collect { result ->
                when (result) {
                    is Result.Success -> {
                        _uiState.value = UiState.Success(result.value)
                    }
                    is Result.Failure -> {
                        _uiState.value = UiState.Error(result.message)
                    }
                }
            }

        }
    }
}