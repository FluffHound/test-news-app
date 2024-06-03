package com.mhanifs.newsapp.features.news.data.repository

import arrow.core.Either
import com.mhanifs.newsapp.core.exception.NetworkError
import com.mhanifs.newsapp.core.exception.toNetworkError
import com.mhanifs.newsapp.features.news.data.remote.NewsApi
import com.mhanifs.newsapp.features.news.domain.entity.News
import com.mhanifs.newsapp.features.news.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {
    override suspend fun getNews(query: HashMap<String, Any>): Either<NetworkError, News> {
        return Either.catch {
            newsApi.getNews(query)
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getHeadlines(query: HashMap<String, Any>): Either<NetworkError, News> {
        return Either.catch {
            newsApi.getHeadlines(query = query)
        }.mapLeft { it.toNetworkError() }
    }
}