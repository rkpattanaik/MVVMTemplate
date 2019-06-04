package com.cognizant.mvvm.data.source

import com.cognizant.mvvm.data.Post
import io.reactivex.Single

interface PostsRepository {

    fun getAllPosts(): Single<List<Post>>
}