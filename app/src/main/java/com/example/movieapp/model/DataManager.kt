package com.example.movieapp.model

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Movie>()

    fun loadAssetsFromJson(context: Context) {
        val inputStream = context.assets.open("film.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        val tempData = gson.fromJson(json, Array<Movie>::class.java)

        data = tempData

    }
}

