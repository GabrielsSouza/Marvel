package com.example.marvelcharactersinfo.data

import android.net.wifi.aware.PublishConfig

import com.example.marvelcharactersinfo.HASH
import com.example.marvelcharactersinfo.PUBLIC_KEY
import com.example.marvelcharactersinfo.TS
import com.example.marvelcharactersinfo.data.response.CharacterResponse
import com.example.marvelcharactersinfo.md5
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface MarvelService {
    //Mapeamento de endPoints
    @GET("characters")
    fun getCharacter(
        @Query("ts") ts: String = TS,
        @Query("api_key") apiKey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()
    ): Call<CharacterResponse>
}