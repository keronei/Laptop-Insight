package com.keronei.android.laptopReview.ui.favourite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.keronei.android.laptopReview.ui.articles.widgets.ArticleView
import timber.log.Timber

@Composable
fun FavouriteScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    favouriteViewModel: FavouriteViewModel = viewModel()
) {
    val favourites by favouriteViewModel.articles.collectAsState()

    if (favourites.isEmpty()) {
        Column(
            modifier = modifier
                .padding(8.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "There are no Favourites")
        }
    } else {
        LazyColumn(content = {
            items(items = favourites) { item ->
                ArticleView(
                    item = item,
                    onSelected = {
                        //Timber.tag("Controller").d(navigationController.toString())
                        favouriteViewModel.selectedArticle = item
                        navController.navigate("favDetail")
                    }
                )
            }
        }, modifier = modifier.padding(8.dp))
    }

}