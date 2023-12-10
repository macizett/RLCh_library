package com.mayonnaise.rlchlibrary.interfaces

import com.mayonnaise.rlchlibrary.models.BlogPostModel
import retrofit2.http.GET

interface BlogService {
    @GET("main/articles.json")
    suspend fun listArticles(): List<BlogPostModel>
}