package com.cognizant.mvvm.data.source

import com.cognizant.mvvm.data.Post
import com.cognizant.mvvm.data.source.remote.Api
import io.reactivex.Single
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(val api: Api): PostsRepository {

    override fun getAllPosts(): Single<List<Post>> {
        return api.getAllPosts().map { it.posts }
    }
}