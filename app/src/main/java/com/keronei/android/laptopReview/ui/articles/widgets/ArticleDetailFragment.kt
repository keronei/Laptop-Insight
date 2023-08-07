package com.keronei.android.laptopReview.ui.articles.widgets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.keronei.android.laptopReview.R
import com.keronei.android.laptopReview.ui.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArticleDetailFragment : Fragment() {
    private val homeViewModel by viewModel<ArticlesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {

            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            setContent {
                val articleLink = homeViewModel.selectedArticle?.link

                val favourited = remember { mutableStateOf(false) }

                Scaffold(floatingActionButton = {
                    if (articleLink != null) {
                        FloatingActionButton(
                            onClick = {
                                favourited.value = !favourited.value
                            },
                            modifier = Modifier
                                .padding(bottom = 48.dp)
                                .background(color = Color.Transparent)
                        ) {
                            Icon(
                                if (favourited.value) {
                                    Icons.Filled.FavoriteBorder
                                } else {
                                    Icons.Filled.Favorite
                                },
                                contentDescription = context.getString(R.string.favourite)
                            )
                        }
                    }
                }) { contentPadding ->

                    if (articleLink != null) {

                        Column(modifier = Modifier.padding(contentPadding)) {

                            val state = rememberWebViewState(url = articleLink)
                            WebView(state = state
                            )
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
                                text = context.getString(R.string.could_not_get_the_selected_article),
                                style = TextStyle(
                                    fontSize = 18.sp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}