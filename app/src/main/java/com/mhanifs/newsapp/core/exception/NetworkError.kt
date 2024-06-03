package com.mhanifs.newsapp.core.exception

data class NetworkError (
    val error: ApiError,
    val t: Throwable?,
)

enum class ApiError(val message: String) {
    NetworkError("Network error"),
    UnknownError("Unknown error"),
    UnknownResponse("Unknown response"),
}