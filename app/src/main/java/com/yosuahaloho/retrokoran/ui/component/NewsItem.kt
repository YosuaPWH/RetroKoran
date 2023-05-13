package com.yosuahaloho.retrokoran.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.yosuahaloho.retrokoran.R
import com.yosuahaloho.retrokoran.domain.model.Article
import com.yosuahaloho.retrokoran.domain.model.NewsItemModel
import com.yosuahaloho.retrokoran.domain.model.Source
import com.yosuahaloho.retrokoran.ui.theme.RetroKoranTheme
import com.yosuahaloho.retrokoran.ui.theme.backgroundNews

/**
 * Created by Yosua on 12/05/2023
 */
@Composable
fun NewsItem(
    article: Article
) {
    Box(
        modifier = Modifier.height(123.dp)
    ) {
        Row(
            modifier = Modifier
                .background(backgroundNews)
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(modifier = Modifier.weight(2f)) {
                Text(
                    text = "By ${article.source.name}",
                    fontSize = 12.sp
                )
                Text(
                    text = article.title,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = article.publishedAt.toString(),
                    fontSize = 12.sp
                )
            }
            AsyncImage(
                model = article.urlToImage,
                contentDescription = article.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
                    .width(100.dp)
                    .fillMaxSize()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsItemPreview() {
    RetroKoranTheme {
        NewsItem(
            Article(
                title = "From democrat to autocrat. The story of Turkey's Recep Tayyip Erdogan",
                source = Source("", "SoeratKabar Lama"),
                publishedAt = "Senin 15 Juli 1932",
                urlToImage = "",
                author = "",
                content = "",
                description = "",
                url = ""
            )
        )
    }
}