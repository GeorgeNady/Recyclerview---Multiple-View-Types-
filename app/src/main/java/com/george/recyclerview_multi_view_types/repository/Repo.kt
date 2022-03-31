package com.george.recyclerview_multi_view_types.repository

import com.george.recyclerview_multi_view_types.model.Model

object Repo {

    val dummyData = listGenerator()

    private fun listGenerator(): List<Model> {
        val result = mutableListOf<Model>()

        for (i in 0..100) {
            when ((0..1).random()) {
                0 -> {
                    val item = Model("title $i", "des $i", "https://picsum.photos/200/300", 0)
                    result.add(item)
                }
                1 -> {
                    val item = Model(null,null,"https://picsum.photos/200/300",1)
                    result.add(item)
                }
            }
        }
        return result
    }

}