package com.example.marvelcharactersinfo.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse (
    @Json(name = "data")
    val data : ResultsResponse
)