package com.skycore.practicaltest.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.skycore.practicaltest.BuildConfig
import com.skycore.practicaltest.model.Businesses
import com.skycore.practicaltest.retrofit.RetrofitService


class BusinessesPagingSource(private val apiService: RetrofitService, val radius: Int): PagingSource<Int, Businesses>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Businesses> {
        return try {
            val position = params.key ?: 1
            val response = apiService.getBusinessesList(
                term = "restaurants",
                location = "NYC",
                radius = radius,
                sort_by = "distance",
                limit = 15,
                authorization = BuildConfig.API_KEY,
                accept = "application/json"
            )

            val businessList = response.body()!!.businesses
            if(response.isSuccessful)
            {
                LoadResult.Page(data = businessList, prevKey = if (position == 1) null else position - 1,
                    nextKey = if(businessList.size < 15) null else position + 1)
            }
            else{
                LoadResult.Error(throwable = Throwable(response.message()))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Businesses>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}

