package com.example.marvelcharactersinfo.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object APIService {

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service: MarvelService = initRetrofit().create(MarvelService::class.java)

}


