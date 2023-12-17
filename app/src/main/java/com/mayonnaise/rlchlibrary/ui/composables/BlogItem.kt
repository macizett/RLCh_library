package com.mayonnaise.rlchlibrary.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mayonnaise.rlchlibrary.viewmodels.BlogViewModel

@Composable
fun BlogItem(title: String, text: String, author: String, id: Int, date: String, viewModel: BlogViewModel){

      Card (modifier = Modifier.padding(4.dp), colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
      )) {
            Column (modifier = Modifier
                  .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)) {

                  Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp, textAlign = TextAlign.Center, modifier = Modifier
                        .padding(start = 8.dp, bottom = 8.dp, end = 8.dp)
                        .align(Alignment.CenterHorizontally))

                  Spacer(modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.onBackground))

                  ExpandableText(text = text)

                  Spacer(modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.onBackground))

                  Row (modifier = Modifier.fillMaxWidth().padding(top = 4.dp, bottom = 4.dp)){
                        Text(text = author, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface, textAlign = TextAlign.Start, modifier = Modifier.padding(start = 4.dp, end = 4.dp).weight(1f))
                        Text(text = date, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface, textAlign = TextAlign.End, modifier = Modifier.padding(start = 4.dp,end = 4.dp).weight(1f))
                  }

                  Spacer(modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.onBackground))

                  Row (modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)){
                        IconButton(onClick = {

                              //TODO CLICK

                        }, modifier = Modifier
                              .weight(1f)
                              .graphicsLayer {
                                    scaleX = 1.2f
                                    scaleY = 1.2f
                              }) {
                              Icon(
                                    Icons.Filled.Favorite, contentDescription = "Favorites Button",
                                    tint = MaterialTheme.colorScheme.onBackground)
                        }

                        IconButton(onClick = { viewModel.share(text, title) }, modifier = Modifier
                              .weight(1f)
                              .graphicsLayer {
                                    scaleX = 1.2f
                                    scaleY = 1.2f
                              }) {
                              Icon(
                                    Icons.Filled.Share, contentDescription = "Share Button",
                                    tint = MaterialTheme.colorScheme.onBackground)
                        }
                  }
            }
      }

}

@Composable
fun ExpandableText(text: String) {
      var isExpanded by remember { mutableStateOf(false) }

      val checkedText = buildAnnotatedString {
            if (text.length <= 180) {
                  append(text)
            } else {
                  if (isExpanded) {
                        append(text)
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontWeight = FontWeight.SemiBold)) {
                              append(" ...zobacz mniej")
                        }
                  } else {
                        append(text.take(180))
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground, fontWeight = FontWeight.SemiBold)) {
                              append(" ...zobacz więcej")
                        }
                  }
            }
      }

      Box(
            modifier = Modifier
                  .padding(8.dp)
                  .clickable { isExpanded = !isExpanded }
      ) {
            Text(
                  text = checkedText,
                  modifier = Modifier.wrapContentHeight()
            )
      }
}

@Composable
@Preview(showBackground = true)

fun BlogItemPreview(){
      //BlogItem("title", "text")
}