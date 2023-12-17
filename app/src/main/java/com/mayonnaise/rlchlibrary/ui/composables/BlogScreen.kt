package com.mayonnaise.rlchlibrary.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mayonnaise.rlchlibrary.viewmodels.BlogViewModel

@Composable
fun BlogScreen(viewModel: BlogViewModel){

    LaunchedEffect(Unit) {
        viewModel.refreshNetworkStatus()
    }

    val articles by viewModel.blogPosts.observeAsState(initial = emptyList())

    val isNetworkAvailable by viewModel.isNetworkAvailable.observeAsState()

    Column (modifier = Modifier.fillMaxSize()){

        if(articles.isEmpty()){
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column {

                    if (isNetworkAvailable == false){
                        Text(
                            text = "Brak połączenia z Internetem",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center
                        )


                        Button(onClick = {viewModel.refreshNetworkStatus()}, modifier = Modifier
                            .padding(top = 12.dp)
                            .align(Alignment.CenterHorizontally)) {
                            Text(text = "Spróbuj ponownie")
                        }
                    }

                    else{

                        LaunchedEffect(key1 = "loadPosts"){
                            viewModel.loadBlogPosts()
                        }

                        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Ładowanie...",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center
                        )
                    }

                }
            }
        }
        if(isNetworkAvailable == true && articles.isNotEmpty()){

            LazyColumn (modifier = Modifier.padding(top = 8.dp, bottom = 140.dp, start = 4.dp, end = 4.dp)){
                items(articles) { item ->
                    BlogItem(item.title, item.text, item.author, item.id, item.date, viewModel)
                }
            }

        }

    }
}