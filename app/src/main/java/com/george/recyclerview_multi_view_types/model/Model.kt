package com.george.recyclerview_multi_view_types.model

data class Model(
    val title: String?,
    val description: String? = null,
    val image: String,
    val type: Int
)