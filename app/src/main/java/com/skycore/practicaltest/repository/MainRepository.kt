package com.skycore.practicaltest.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.skycore.practicaltest.model.Businesses
import com.skycore.practicaltest.paging.BusinessesPagingSource
import com.skycore.practicaltest.retrofit.RetrofitService

class MainRepository constructor(private val apiService: RetrofitService) {

    fun getAllRestaurant(radius:Int): LiveData<PagingData<Businesses>> {
        return Pager(
            config = PagingConfig(
                pageSize = 1,
                enablePlaceholders = true,
                initialLoadSize = 15,
                prefetchDistance = 2,
            ),
            pagingSourceFactory = {
                BusinessesPagingSource(apiService, radius)
            }, initialKey = 1
        ).liveData
    }

}