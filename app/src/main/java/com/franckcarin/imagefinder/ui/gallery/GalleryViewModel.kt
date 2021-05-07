/*
 * Created by Tchuitio Franck on 06/05/21 12:59
 */

package com.franckcarin.imagefinder.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.franckcarin.imagefinder.data.UnsplashRepository

class GalleryViewModel @ViewModelInject constructor(private val repository: UnsplashRepository) :
    ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }

    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    companion object {
        private const val DEFAULT_QUERY = "cats"
    }
}