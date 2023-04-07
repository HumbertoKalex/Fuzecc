package com.example.remote

import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException

sealed class SafeResponse<out T>(val status: Status) {
    object NetworkError : SafeResponse<Nothing>(Status.NETWORK_ERROR)
    data class Success<out T>(val value: T) : SafeResponse<T>(Status.SUCCESS)
    data class GenericError(
        val code: Int? = null, val throwable: Throwable? = null, val errorBody: ErrorResponse? = null
    ) : SafeResponse<Nothing>(Status.ERROR)
}

suspend fun <T> safeRequest(request: suspend () -> T): SafeResponse<T> {
    return try {
        SafeResponse.Success(request())
    } catch (throwable: Throwable) {
        return when (throwable) {
            is IOException -> SafeResponse.NetworkError
            is HttpException -> convertToErrorBody(throwable)
            else -> SafeResponse.GenericError(null, throwable)
        }
    }
}

private fun <T> convertToErrorBody(throwable: HttpException): SafeResponse<T> {
    return try {
        throwable.response()?.errorBody()?.let {
            val body = Gson().fromJson(it.charStream(), ErrorResponse::class.java)
            SafeResponse.GenericError(throwable.code(), throwable, body)
        } ?: SafeResponse.GenericError(throwable.code(), throwable)
    } catch (exception: Exception) {
        return SafeResponse.GenericError(throwable.code(), throwable)
    }
}

enum class Status {
    SUCCESS, ERROR, NETWORK_ERROR,
}