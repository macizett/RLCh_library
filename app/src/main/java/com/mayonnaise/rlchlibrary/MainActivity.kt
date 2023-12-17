package com.mayonnaise.rlchlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mayonnaise.rlchlibrary.interfaces.BlogService
import com.mayonnaise.rlchlibrary.repositories.BlogRepository
import com.mayonnaise.rlchlibrary.ui.NavController
import com.mayonnaise.rlchlibrary.ui.composables.BaseScreen
import com.mayonnaise.rlchlibrary.ui.composables.BlogScreen
import com.mayonnaise.rlchlibrary.ui.composables.BookSelectorScreen
import com.mayonnaise.rlchlibrary.ui.theme.RLCHLibraryTheme
import com.mayonnaise.rlchlibrary.viewmodels.BlogViewModel
import com.mayonnaise.rlchlibrary.viewmodels.BookSelectorViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val blogService = retrofit.create(BlogService::class.java)

        val blogRepository = BlogRepository(blogService)

        val blogViewModel = BlogViewModel(blogRepository, this)
        val bookSelectorViewModel = BookSelectorViewModel()
        setContent {
            RLCHLibraryTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavController(blogViewModel = blogViewModel, bookSelectorViewModel = bookSelectorViewModel, context = this)
                }
            }
        }
    }
}
