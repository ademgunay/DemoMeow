package com.gunaya.demo.demomeow.presentation.main

import android.arch.lifecycle.MutableLiveData
import com.gunaya.demo.demomeow.utils.SingleLiveEvent
import com.gunaya.demo.demomeow.utils.UseCaseResult
import com.gunaya.demo.demomeow.data.entities.Cat
import com.gunaya.demo.demomeow.data.repositories.CatRepository
import com.gunaya.demo.demomeow.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val catRepository: CatRepository) : BaseViewModel() {

    val showLoading = MutableLiveData<Boolean>()
    val catsList = MutableLiveData<List<Cat>>()
    val showError = SingleLiveEvent<String>()
    val navigateToDetail = SingleLiveEvent<String>()

    fun loadCats() {
        // Show progressBar during the operation on the MAIN (default) thread
        showLoading.value = true
        // launch the Coroutine
        launch {
            // Switching from MAIN to IO thread for API operation
            // Update our data list with the new one from API
            val result = withContext(Dispatchers.IO) { catRepository.getCatsList() }
            // Hide progressBar once the operation is done on the MAIN (default) thread
            showLoading.value = false
            when (result) {
                is UseCaseResult.Success -> catsList.value = result.data
                is UseCaseResult.Error -> showError.value = result.exception.message
            }
        }
    }

    fun catClicked(imageUrl: String) {
        navigateToDetail.value = imageUrl
    }
}
