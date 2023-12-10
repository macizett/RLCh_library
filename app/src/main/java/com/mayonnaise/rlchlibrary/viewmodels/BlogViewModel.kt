package com.mayonnaise.rlchlibrary.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayonnaise.rlchlibrary.interfaces.BlogService
import com.mayonnaise.rlchlibrary.models.BlogPostModel
import com.mayonnaise.rlchlibrary.repositories.BlogRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BlogViewModel (private val repository: BlogRepository): ViewModel() {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/macizett/RLCh_books")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val blogService = retrofit.create(BlogService::class.java)

    private val _blogPosts = MutableLiveData<List<BlogPostModel>>()
    val blogPosts: LiveData<List<BlogPostModel>> = _blogPosts

    init {
        loadBlogPosts()
    }

    private fun loadBlogPosts() {
        viewModelScope.launch {
            try {
                val posts = repository.getBlogPosts()
                _blogPosts.postValue(posts)
            } catch (e: Exception) {

            }
        }
    }
}