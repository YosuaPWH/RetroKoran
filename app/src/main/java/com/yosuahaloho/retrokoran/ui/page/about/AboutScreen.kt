package com.yosuahaloho.retrokoran.ui.page.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yosuahaloho.retrokoran.R
import com.yosuahaloho.retrokoran.ui.theme.DMSans
import com.yosuahaloho.retrokoran.ui.theme.DMSerif
import com.yosuahaloho.retrokoran.ui.theme.RetroKoranTheme
import com.yosuahaloho.retrokoran.ui.theme.selectedBarColor

/**
 * Created by Yosua on 11/05/2023
 */
@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = 50.dp).fillMaxSize()
    ) {
        Text(
            text = "The Creator",
            fontFamily = DMSerif,
            fontSize = 32.sp,
            modifier = modifier.padding(bottom = 5.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.yosuahaloho),
            contentDescription = "Foto Diri",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, selectedBarColor, CircleShape),
        )
        Spacer(modifier = modifier.padding(top = 15.dp))
        Text(
            text = "Yosua Putra Wisesa Haloho",
            fontFamily = DMSerif
        )
        Text(
            text = "halohoyosua1502@gmail.com",
            fontFamily = DMSans
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    RetroKoranTheme {
        AboutScreen()
    }
}
