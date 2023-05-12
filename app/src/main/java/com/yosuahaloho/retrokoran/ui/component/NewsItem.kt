package com.yosuahaloho.retrokoran.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yosuahaloho.retrokoran.R
import com.yosuahaloho.retrokoran.domain.model.NewsItemModel
import com.yosuahaloho.retrokoran.ui.theme.RetroKoranTheme
import com.yosuahaloho.retrokoran.ui.theme.backgroundNews

/**
 * Created by Yosua on 12/05/2023
 */
@Composable
fun NewsItem(
    newsItem: NewsItemModel
) {
    Row(
        modifier = Modifier
            .background(backgroundNews)
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Column {
            Text(
                text = "By ${newsItem.publisher}"
            )
            Text(
                text = newsItem.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )
        }
        Image(
            painter = painterResource(id = R.drawable.sample_image_news),
            contentDescription = newsItem.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(111.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NewsItemPreview() {
    RetroKoranTheme {
        NewsItem(
            NewsItemModel(
                id = 1,
                title = "Plesiran Kota Batavia",
                publisher = "SoeratKabar Lama",
                date = "Senin 15 Juli 1932"
            )
        )
    }
}