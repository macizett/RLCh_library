package com.mayonnaise.rlchlibrary.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mayonnaise.rlchlibrary.R
import com.mayonnaise.rlchlibrary.viewmodels.BlogViewModel


@Composable
fun BaseScreen(navController: NavController, blogViewModel: BlogViewModel){
    val titles = listOf("Blog", "Biblioteka")
    val tabIcons = listOf(R.drawable.baseline_article_24, R.drawable.baseline_menu_book_24)
    var tabIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar( modifier = Modifier
                .height(140.dp)
                .clip(RoundedCornerShape(16.dp)) ,
                content = {
                    Column {
                        TabRow(
                            selectedTabIndex = tabIndex,
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.clip(RoundedCornerShape(12.dp))
                        ) {
                            titles.forEachIndexed { index, title ->
                                Tab(
                                    text = { Text(title) },
                                    icon = {
                                        Icon(
                                            tint = MaterialTheme.colorScheme.onBackground,
                                            imageVector = ImageVector.vectorResource(id = tabIcons[index]),
                                            contentDescription = "book icon"
                                        )
                                    },
                                    selected = tabIndex == index,
                                    onClick = { tabIndex = index }
                                )
                            }
                        }

                        Row(
                            Modifier
                                .fillMaxWidth()
                        ){
                            IconButton(onClick = {

                                //TODO CLICK

                                 }, modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()) {
                                Icon(
                                    Icons.Filled.Favorite, contentDescription = "Favorites Button", modifier = Modifier.graphicsLayer {
                                        scaleX = 1.4f
                                        scaleY = 1.4f
                                    },
                                    tint = MaterialTheme.colorScheme.onBackground)
                            }

                            IconButton(onClick = {

                                //TODO CLICK

                            }, modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()) {
                                Icon(
                                    Icons.Filled.Menu, contentDescription = "SelectorScreen", modifier = Modifier.graphicsLayer {
                                        scaleX = 1.4f
                                        scaleY = 1.4f
                                    },
                                    tint = MaterialTheme.colorScheme.onBackground)
                            }

                            IconButton(onClick = { }, modifier = Modifier

                                //TODO CLICK

                                .weight(1f)
                                .fillMaxHeight()) {
                                Icon(
                                    Icons.Filled.Share, contentDescription = "Share Button", modifier = Modifier.graphicsLayer {
                                        scaleX = 1.4f
                                        scaleY = 1.4f
                                    },
                                    tint = MaterialTheme.colorScheme.onBackground)
                            }
                        }
                    }
                }
            )
        }
    ) {
        padding ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            when (tabIndex) {
                0 -> BlogScreen(viewModel = blogViewModel)
                1 -> BlogScreen(viewModel = blogViewModel)
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun BaseScreenPreview(){
    //BaseScreen()
}
