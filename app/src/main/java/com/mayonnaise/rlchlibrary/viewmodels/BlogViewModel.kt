package com.mayonnaise.rlchlibrary.viewmodels

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayonnaise.rlchlibrary.functions.isNetworkAvailable
import com.mayonnaise.rlchlibrary.interfaces.BlogService
import com.mayonnaise.rlchlibrary.models.BlogPostModel
import com.mayonnaise.rlchlibrary.repositories.BlogRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BlogViewModel (private val repository: BlogRepository, val context: Context): ViewModel() {

    private val _isNetworkAvailable = MutableLiveData<Boolean>()
    val isNetworkAvailable: LiveData<Boolean> = _isNetworkAvailable

    private val _blogPosts = MutableLiveData<List<BlogPostModel>>()
    val blogPosts: LiveData<List<BlogPostModel>> = _blogPosts

    init {
        loadBlogPosts()
        checkNetworkConnection()
    }

    private fun checkNetworkConnection() {
        _isNetworkAvailable.value = isNetworkAvailable(context)
    }

    fun refreshNetworkStatus() {
        checkNetworkConnection()
    }

    fun loadBlogPosts() {
        viewModelScope.launch {
            if (isNetworkAvailable(context)){
                try {
                    val posts = repository.getBlogPosts()
                    _blogPosts.postValue(posts)
                } catch (e: Exception) {
                    Toast.makeText(context, "Błąd. Patrz: logcat.", Toast.LENGTH_LONG).show()
                }
            }
            else{
                refreshNetworkStatus()
            }
        }
    }

    fun share(text: String, title: String) {
        val sharedText = "${title}\r\n\r\n${text}\r\n\r\n\r\n".trimIndent()

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, sharedText)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntent)
    }
}