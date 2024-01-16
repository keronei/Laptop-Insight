package com.keronei.android.laptopReview.ui.articles

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keronei.android.laptopReview.ui.articles.state.ArticlesState
import com.keronei.android.laptopReview.ui.articles.widgets.ArticleView
import timber.log.Timber

@Composable
fun HomeFragment(
    articlesViewModel: ArticlesViewModel,
    navigationController: NavController,
    modifier: Modifier = Modifier
) {
    val articles = articlesViewModel.availableArticles.collectAsState()

    when (val list = articles.value) {
        is ArticlesState.Loading -> {
            Text(text = "Fetching data", modifier = modifier)
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
            }, modifier = modifier)
        }

        is ArticlesState.Empty -> {
            Text(text = "Nothing to show", modifier = modifier)
        }
    }
}

