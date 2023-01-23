package com.aves.practicaltest.sealed

sealed class NetworkResult{
    data class Success<T>(val data: T) : NetworkResult()
    data class Error<T>(val message: String) : NetworkResult()
    object Empty: NetworkResult()
}