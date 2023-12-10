package com.mayonnaise.rlchlibrary.repositories

import com.mayonnaise.rlchlibrary.interfaces.BlogService
import com.mayonnaise.rlchlibrary.models.BlogPostModel

class BlogRepository(private val blogService: BlogService) {

    suspend fun getBlogPosts(): List<BlogPostModel> {
        return blogService.listArticles()
    }

}