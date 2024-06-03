package com.mhanifs.newsapp.features.news.presentation.view.component

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.mhanifs.newsapp.core.ui.LoadingDialog
import com.mhanifs.newsapp.features.news.domain.entity.Article

@Composable
fun LoadingAnimation(pagingData: LazyPagingItems<Article>) {
    pagingData.apply {
        when {
            loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                LoadingDialog()
                Log.i("loading-dialog", "showed")

            }
            loadState.append is LoadState.Error -> {

            }
        }
    }
}