package com.areeb.hussle.ui.screens.home.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.hussle.data.repository.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModels @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    companion object {
        private const val TAG = "HomeViewModels"
    }

    fun getAllProducts() {
        viewModelScope.launch {
            homeRepository.getAllProducts().collectLatest {
                Log.e(TAG, it.toString())
            }
        }
    }
}
