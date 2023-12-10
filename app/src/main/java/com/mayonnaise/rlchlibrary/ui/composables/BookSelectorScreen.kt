package com.mayonnaise.rlchlibrary.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mayonnaise.rlchlibrary.R

@Composable
fun BookSelectorScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.bookcover), contentDescription = "book cover", modifier = Modifier
                .height(80.dp)
                .width(60.dp)
                .padding(top = 4.dp, bottom = 4.dp, start = 4.dp)
            )

            Column {
                Text(text = "Book Title", modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp))
                Text(text = "Author", modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp))
            }
        }
    }
}