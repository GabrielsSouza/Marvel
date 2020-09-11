package com.example.marvelcharactersinfo.presentation.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelcharactersinfo.data.APIService
import com.example.marvelcharactersinfo.data.model.Character
import com.example.marvelcharactersinfo.data.response.CharacterResponse
import com.example.marvelcharactersinfo.data.response.HeroDetailsResponse
import com.example.marvelcharactersinfo.data.response.ResultsResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class CharacterViewModel : ViewModel() {

    val _characterLiveData: MutableLiveData<List<HeroDetailsResponse>> = MutableLiveData()
    val characterLiveData : LiveData<List<HeroDetailsResponse>> = _characterLiveData

    fun getCharacter (){
        APIService.service.getCharacter().enqueue(object: retrofit2.Callback<CharacterResponse>{

            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                if(response.isSuccessful){
                    val heroes: MutableList<Character> = mutableListOf()

                    response.body()?.let {
                        _characterLiveData.value = it.data.results
                    }

                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {

            }


        })
    }
}