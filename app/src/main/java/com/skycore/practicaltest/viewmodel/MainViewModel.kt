package com.skycore.practicaltest.viewmodel

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.skycore.practicaltest.repository.MainRepository

class MainViewModel(private val mainRepository: MainRepository):ViewModel() {

    val radius = MutableLiveData(500)
    val distance = radius.map {
        when{
            it!! < 1000 -> "${radius.value} M"
            else -> {
                "${radius.value?.toDouble()?.div(1000)} KM"
            }
        }
    }

    val restaurantList = radius.switchMap { int ->
        mainRepository.getAllRestaurant(int)
    }.cachedIn(viewModelScope)

}