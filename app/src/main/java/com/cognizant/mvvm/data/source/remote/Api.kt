package com.cognizant.mvvm.data.source.remote

import io.reactivex.Single
import retrofit2.http.GET

interface Api {

    companion object {
        const val BASE_URL = "https://cognizant.com/api/"
    }

    @GET("posts")
    fun getAllPosts(): Single<GetAllPostsResponse>
}