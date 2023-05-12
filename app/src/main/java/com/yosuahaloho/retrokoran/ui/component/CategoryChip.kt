package com.yosuahaloho.retrokoran.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yosuahaloho.retrokoran.ui.navigation.ChipsItem
import com.yosuahaloho.retrokoran.ui.theme.RetroKoranTheme

/**
 * Created by Yosua on 12/05/2023
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryChipLayout() {
    val chipsItem = listOf(
        ChipsItem(
            topic = "All"
        ),
        ChipsItem(
            topic = "Politic"
        ),
        ChipsItem(
            topic = "Sport"
        ),
        ChipsItem(
            topic = "Education"
        ),
        ChipsItem(
            topic = "Economic"
        )
    )
    var chipState by remember { mutableStateOf("") }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(chipsItem, key = { it.topic }) {
            FilterChipItem(
                chipsItem = it,
                isSelected = it.topic == chipState,
                clickChip = { chip ->
                    chipState = chip
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipItem(
    chipsItem: ChipsItem,
    isSelected: Boolean,
    clickChip: (String) -> Unit
) {
    FilterChip(
        label = {
            Text(
                text = chipsItem.topic,
                modifier = Modifier.width(90.dp),
                textAlign = TextAlign.Center
            )
        },
        selected = isSelected,
        onClick = {
            if (!isSelected) {
                clickChip(chipsItem.topic)
            } else {
                clickChip("")
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun CategoryChipLayoutPreview() {
    RetroKoranTheme {
        CategoryChipLayout()
    }
}