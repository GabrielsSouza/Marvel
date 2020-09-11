package com.example.marvelcharactersinfo.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultsResponse (
    @Json(name = "results")
    val results : List <HeroDetailsResponse>
)
