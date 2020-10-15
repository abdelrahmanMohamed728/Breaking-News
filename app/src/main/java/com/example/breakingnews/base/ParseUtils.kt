package com.example.breakingnews.base

import com.google.gson.Gson
import com.google.gson.JsonParser
import java.util.*

object ParserUtils {
    fun <T> fromJsonString(
        gson: Gson,
        tListJson: String?,
        tClass: Class<T>?
    ): MutableList<T> {
        if (tListJson == null || tListJson.isEmpty()) return ArrayList()
        val jsonListArray = JsonParser().parse(tListJson).asJsonArray
        if (jsonListArray != null) {
            val list: MutableList<T> = ArrayList()
            for (i in 0 until jsonListArray.size()) list.add(
                gson.fromJson(
                    jsonListArray[i],
                    tClass
                )
            )
            return list
        }
        return ArrayList()
    }

    fun <T> fromJsonString(
        tListJson: String?,
        tClass: Class<T>?
    ): MutableList<T> {
        return fromJsonString(Gson(), tListJson, tClass)
    }
}