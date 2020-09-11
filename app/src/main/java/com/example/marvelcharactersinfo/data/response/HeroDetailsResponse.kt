package com.example.marvelcharactersinfo.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass (generateAdapter = true)
data class HeroDetailsResponse(
    @Json (name = "name")
    val name : String,
    @Json (name = "description")
    val description : String,
    @Json (name = "thumbnail")
    val thumbnail : String

)
