package com.yosuahaloho.retrokoran.ui.page.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yosuahaloho.retrokoran.R
import com.yosuahaloho.retrokoran.domain.model.NewsItemModel
import com.yosuahaloho.retrokoran.ui.component.CategoryChipLayout
import com.yosuahaloho.retrokoran.ui.component.NewsItem
import com.yosuahaloho.retrokoran.ui.navigation.ChipsItem
import com.yosuahaloho.retrokoran.ui.theme.DMSerif
import com.yosuahaloho.retrokoran.ui.theme.RetroKoranTheme

/**
 * Created by Yosua on 11/05/2023
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
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
        NewsItem(
            newsItem = NewsItemModel(
                id = 1,
                title = "Plesiran Kota Batavia",
                publisher = "SoeratKabar Lama",
                date = "Senin 15 Juli 1932"
            )
        )
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    RetroKoranTheme {
        HomeScreen()
    }
}