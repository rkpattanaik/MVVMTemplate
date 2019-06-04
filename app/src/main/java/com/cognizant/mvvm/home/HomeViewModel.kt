package com.cognizant.mvvm.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cognizant.mvvm.data.Post
import com.cognizant.mvvm.data.source.PostsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: PostsRepository): ViewModel() {

    private val postsLiveData = MutableLiveData<List<Post>>()
    private val errorLiveData = MutableLiveData<String>()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        getAllPosts()
    }

    private fun getAllPosts() {
        repository.getAllPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ posts -> postsLiveData.value = posts },
                { error -> errorLiveData.value = error.message })
            .let { compositeDisposable.add(it) }
    }

    fun getPostsLiveData() = postsLiveData

    fun getErrorLiveData() = errorLiveData

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
    }
}