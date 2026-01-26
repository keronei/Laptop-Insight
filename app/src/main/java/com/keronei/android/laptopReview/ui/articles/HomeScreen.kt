package com.keronei.android.laptopReview.ui.articles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keronei.android.laptopReview.ui.articles.state.ArticlesState
import com.keronei.android.laptopReview.ui.articles.widgets.ArticleView
import timber.log.Timber

@Composable
fun HomeScreen(
    articlesViewModel: ArticlesViewModel,
    navigationController: NavController,
    modifier: Modifier = Modifier
) {
    val articles = articlesViewModel.availableArticles.collectAsState()

    when (val list = articles.value) {
        is ArticlesState.Loading -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
                Spacer(Modifier.height(12.dp))
                Text(text = "Fetching data")
            }
        }

        is ArticlesState.Data -> {
            val items = list.articles

            LazyColumn(content = {
                items(items = items) { item ->
                    ArticleView(
                        item = item,
                        onSelected = {
                            Timber.tag("Controller").d(navigationController.toString())
                            articlesViewModel.selectedArticle = item
                            navigationController.navigate("articleDetail")
                        }
                    )
                }
            }, modifier = modifier.padding(8.dp))
        }

        is ArticlesState.Empty -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
                Spacer(Modifier.height(12.dp))
                Text(text = "Nothing to show")
            }
        }
    }
}

