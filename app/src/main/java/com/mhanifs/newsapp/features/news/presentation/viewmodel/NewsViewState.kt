package com.mhanifs.newsapp.features.news.presentation.viewmodel

import androidx.compose.ui.focus.FocusRequester
import com.mhanifs.newsapp.core.utils.Endpoint
import com.mhanifs.newsapp.R

data class NewsViewState(
    val endpoint: Endpoint = Endpoint.EVERYTHING,
    val newsFocus: FocusRequester = FocusRequester(),
    val newsIcon: Int = R.drawable.solid_newspaper,
    val headlinesFocus: FocusRequester = FocusRequester(),
    val headlinesIcon: Int = R.drawable.fire_regular
)