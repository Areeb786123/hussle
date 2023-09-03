package com.areeb.hussle.ui.screens.home.viewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.hussle.data.Resource
import com.areeb.hussle.data.models.storesModule.StoresDtoItem
import com.areeb.hussle.data.repository.home.HomeRepository
import com.areeb.hussle.utils.CommonString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModels @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    companion object {
        private const val TAG = "HomeViewModels"
    }

    private val _loading = MutableStateFlow(true)
    var loading: StateFlow<Boolean> = _loading

    private val _productItem = MutableStateFlow<List<StoresDtoItem>>(emptyList())
    var productItem: StateFlow<List<StoresDtoItem>> = _productItem

    fun getAllProducts() {
        viewModelScope.launch {
            homeRepository.getAllProducts().collectLatest {
                getAllProductResource(it)
            }
        }
    }

    private fun getAllProductResource(resource: Resource<List<StoresDtoItem>>) {
        when (resource) {
            is Resource.SUCCESS -> {
                _loading.value = false
                _productItem.value = resource.data
            }

            is Resource.ERROR<*> -> {
                Log.e(TAG, resource.errorMessage.toString())
            }

            else -> {
                Log.e(TAG, CommonString.ERROR)
            }
        }
    }
}
