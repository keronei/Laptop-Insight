package com.keronei.android.laptopReview.ui.favourite

import android.graphics.Bitmap
import android.webkit.WebView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.keronei.android.laptopReview.R
import timber.log.Timber

@Composable
fun FavoriteDetailScreen(
    favouriteViewModel: FavouriteViewModel,
) {

    val article = favouriteViewModel.selectedArticle
    val articleLink = article?.link

    val isLoading = remember {
        mutableStateOf(false)
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface
    ) { contentPadding ->
        if (articleLink != null) {

            val state = rememberWebViewState(url = articleLink)

            Column(modifier = Modifier.padding(contentPadding)) {

                val webViewClient = object : AccompanistWebViewClient() {
                    override fun onPageStarted(
                        view: WebView,
                        url: String?,
                        favicon: Bitmap?
                    ) {
                        isLoading.value = true
                        Timber.tag("Loader").d("Starting to load")
                        Timber.tag("Loader").d("isLoading : ${state.isLoading}")

                        super.onPageStarted(view, url, favicon)
                    }

                    override fun onPageFinished(view: WebView, url: String?) {
                        super.onPageFinished(view, url)
                        isLoading.value = false
                        Timber.tag("Loader").d("Done Loading")
                        Timber.tag("Loader").d("isLoading : ${isLoading.value}")
                    }
                }

                Box {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(
                                if (isLoading.value) {
                                    1f
                                } else {
                                    -1f
                                }
                            )
                    ) {
                        CircularProgressIndicator()
                    }

                    WebView(
                        state = state,
                        client = webViewClient,
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(
                                if (isLoading.value) {
                                    -1f
                                } else {
                                    1f
                                }
                            ),
                    )
                }
            }

        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = LocalContext.current.getString(R.string.could_not_get_the_selected_article),
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
            }
        }
    }
}
