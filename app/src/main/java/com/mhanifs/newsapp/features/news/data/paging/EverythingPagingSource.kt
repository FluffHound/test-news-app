package com.mhanifs.newsapp.features.news.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import arrow.core.Either
import com.mhanifs.newsapp.core.utils.Event
import com.mhanifs.newsapp.core.utils.sendEvent
import com.mhanifs.newsapp.features.news.domain.entity.Article
import com.mhanifs.newsapp.features.news.domain.entity.request.EverythingEndpointParam
import com.mhanifs.newsapp.features.news.domain.repository.NewsRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class EverythingPagingSource @Inject constructor(
    private val repository: NewsRepository,
) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        delay(3000)
        val page = params.key ?: 1
        val param = EverythingEndpointParam(
            q = "bbm",
            source = "id",
            pageSize = params.loadSize,
            page = page,
        )

        Log.i("api-paging-news-source-page", "page: $page")

        return when(val response = repository.getNews(param.toHashMap())) {
            is Either.Left -> {
                response.onLeft {
                    // send toast
                    sendEvent(Event.ToastMessage(it.error.message))
                }
                LoadResult.Error(response.leftOrNull()?.t ?: Throwable(message = "Unknown error"))
            }
            is Either.Right -> {
                var data: List<Article> = emptyList()

                response.onRight {
                    data = it.articles
                    Log.i("api-paging-news-source-status", "status: ${it.status}")
                }

                LoadResult.Page(
                    data = data,
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = if (data.isEmpty()) null else page + 1
                )
            }
        }
    }
}