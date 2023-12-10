package com.mayonnaise.rlchlibrary.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BlogItem(){

      Card (modifier = Modifier.padding(4.dp).height(400.dp)) {
            Column (modifier = Modifier
                  .padding(8.dp)) {

                  Text(text = "Article title", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp, bottom = 4.dp, end = 8.dp))
                  Spacer(modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.outlineVariant))
                  Text(text = "Article text", modifier = Modifier
                        .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 8.dp)
                        .verticalScroll(rememberScrollState())
                  )
            }
      }

}

@Composable
@Preview(showBackground = true)

fun BlogItemPreview(){
      BlogItem()
}