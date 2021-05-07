/*
 * Created by Tchuitio Franck on 06/05/21 12:55
 */

package com.franckcarin.imagefinder.data

import android.app.DownloadManager
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.franckcarin.imagefinder.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor (private val unsplashApi: UnsplashApi) {

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashApi, query)}
        ).liveData


}