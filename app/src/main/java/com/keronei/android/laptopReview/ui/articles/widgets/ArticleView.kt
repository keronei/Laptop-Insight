package com.keronei.android.laptopReview.ui.articles.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.keronei.android.domain.models.Article
import com.keronei.android.laptopReview.ui.articles.ArticlesViewModel
import java.util.Calendar

@Composable
fun ArticleView(
    item: Article,
    onSelected: (article: Article) -> Unit) {

    Card(
        modifier = Modifier
            .padding(4.dp).
        clickable { onSelected(item) },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
        ) {
            AsyncImage(
                model = item.banner,
                modifier = Modifier
                    .height(200.dp),
                contentDescription = item.description,
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 100f
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart,
                content = {
                    Text(
                        text = item.title,
                        style = TextStyle(color = Color.White, fontSize = 16.sp)
                    )
                }
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ArticleViewPreview() {
    val item = Article(
        banner = "https://cdn.mos.cms.futurecdn.net/SiYyzbCCJuJ68g3XX6bPT7.jpg",
        description = "Lenovo back to school sale 2023: Save up to 76% on laptops, tablets, monitors and more  ",
        title = "Lenovo back to school sale 2023: Save up to 76% on laptops, tablets, monitors and more  ",
        link = "https://www.techradar.com/news/lenovo-back-to-school-sale-2021-save-up-to-76-on-laptops-tablets-monitors-and-more",
        publicationDate = Calendar.getInstance().time,
        guid = "sds"

    )
    ArticleView(item = item, {})
}