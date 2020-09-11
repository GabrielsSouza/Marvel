package com.example.marvelcharactersinfo.presentation.characters

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

    val characterLiveData: MutableLiveData<List<Character>> = MutableLiveData()

    fun getCharacter (){
        //characterLiveData.value = getCharacter()
        APIService.service.getCharacter().enqueue(object: retrofit2.Callback<CharacterResponse>{
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                if(response.isSuccessful){
                    val heroes: MutableList<Character> = mutableListOf()

                    response.body()?.let { characterResponse ->
                        for (results in characterResponse.data.results){
                            val character : Character = Character(
                                name = results.name,
                                description = results.description,
                                imagehero = results.thumbnail,
                                extension = results.thumbnail
                            )
                            heroes.add(character)
                        }
                    }

                    characterLiveData.value = heroes
                }
            }

        })
    }
}