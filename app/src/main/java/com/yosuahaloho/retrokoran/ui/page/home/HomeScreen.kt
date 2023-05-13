package com.yosuahaloho.retrokoran.ui.page.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yosuahaloho.retrokoran.domain.model.Article
import com.yosuahaloho.retrokoran.domain.model.NewsItemModel
import com.yosuahaloho.retrokoran.domain.model.Source
import com.yosuahaloho.retrokoran.ui.component.CategoryChipLayout
import com.yosuahaloho.retrokoran.ui.component.NewsItem
import com.yosuahaloho.retrokoran.ui.theme.DMSerif
import com.yosuahaloho.retrokoran.ui.theme.RetroKoranTheme
import com.yosuahaloho.retrokoran.util.UiState
import kotlinx.coroutines.flow.collect

/**
 * Created by Yosua on 11/05/2023
 */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { 
        when (it) {
            is UiState.Loading -> {
                viewModel.getHeadlineNews("us")
            }
            is UiState.Success -> {
                HomeContent(headlineNews = it.data)
            }
            is UiState.Error -> {
                Log.d("HAHAHAHErrro", it.errorMessage)
            }
        }
    }
}

@Composable
fun HomeContent(
    headlineNews: List<Article>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "RetroKoran",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp,
                    fontFamily = DMSerif
                )
                Text(
                    text = "Pilihan Koran Hari Ini",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    fontFamily = DMSerif
                )
            }
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = modifier.size(30.dp)
            )
        }
        CategoryChipLayout()
        LazyColumn {
            items(headlineNews, key = { it.title }) { article ->
                NewsItem(
                    article = article
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    RetroKoranTheme {
        HomeContent(
            headlineNews = listOf(
                Article(
                    source = Source("google-news", "Google News"),
                    author = "detikSport",
                    title = "Lalu Zohri Batal Tampil di Nomor Final Lari 100 Meter SEA Games 2023 - detikSport",
                    description = null,
                    url = null,
                    urlToImage = null,
                    content = null,
                    publishedAt = "2023-05-12T08:17:50Z"
                )
            )
        )
    }
}