package com.example.marvelcharactersinfo.presentation.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelcharactersinfo.data.APIService
import com.example.marvelcharactersinfo.data.model.Character
import com.example.marvelcharactersinfo.data.response.CharacterResponse
import com.example.marvelcharactersinfo.data.response.HeroDetailsResponse
import retrofit2.Call
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    val heroLiveDataMutable: MutableLiveData<List<HeroDetailsResponse>> = MutableLiveData()
    val heroLiveData : LiveData<List<HeroDetailsResponse>> = heroLiveDataMutable

    fun getCharacter (){
        APIService.service.getCharacter().enqueue(object: retrofit2.Callback<CharacterResponse>{

            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                if(response.isSuccessful){

                    response.body()?.let {characterResponse ->
                        heroLiveDataMutable.value = characterResponse.data.results
                    }
                }
            }
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
            }
        })
    }
}