package com.mayonnaise.rlchlibrary.interfaces

import com.mayonnaise.rlchlibrary.models.BlogPostModel
import retrofit2.Response
import retrofit2.http.GET

interface BlogService {
    @GET("macizett/RLCh_books/main/articles.json")
    suspend fun listBlogPosts(): Response<List<BlogPostModel>>
}