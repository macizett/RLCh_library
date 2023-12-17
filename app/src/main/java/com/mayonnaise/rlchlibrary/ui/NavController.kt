package com.mayonnaise.rlchlibrary.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mayonnaise.rlchlibrary.ui.composables.BaseScreen
import com.mayonnaise.rlchlibrary.ui.composables.BlogScreen
import com.mayonnaise.rlchlibrary.viewmodels.BlogViewModel
import com.mayonnaise.rlchlibrary.viewmodels.BookSelectorViewModel

@Composable
fun NavController(blogViewModel: BlogViewModel, bookSelectorViewModel: BookSelectorViewModel, context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "BaseScreen"){
        composable("BaseScreen") { BaseScreen(navController, blogViewModel)}
        composable("BlogScreen"){ BlogScreen(viewModel = blogViewModel)}
    }
}