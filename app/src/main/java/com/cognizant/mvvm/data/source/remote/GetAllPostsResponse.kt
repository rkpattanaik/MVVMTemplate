package com.cognizant.mvvm.data.source.remote

import com.cognizant.mvvm.data.Post
import com.google.gson.annotations.SerializedName

data class GetAllPostsResponse(
    @SerializedName("posts")
    val posts: List<Post>
)