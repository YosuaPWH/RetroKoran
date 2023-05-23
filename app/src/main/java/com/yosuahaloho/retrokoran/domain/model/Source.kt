package com.yosuahaloho.retrokoran.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Yosua on 22/05/2023
 */
@Parcelize
data class Source(
    val id: String,
    val name: String
): Parcelable
