package com.example.marvelcharactersinfo.presentation.characters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharactersinfo.R
import com.example.marvelcharactersinfo.presentation.description.DescriptionHeroesActivity
import kotlinx.android.synthetic.main.activity_personagens.*

class CharacterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personagens)

        //Pegando a String para nomear a Main activity
        toolbarMain.title = getString(R.string.app_name)
        setSupportActionBar(toolbarMain)

        //Instanciando a ViewModel
        val viewModel : CharacterViewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)

        viewModel.heroLiveData.observe(this, Observer {
            it?.let {HeroDetailsResponse ->
                with(recyclerTitulo){
                    layoutManager = LinearLayoutManager(this@CharacterActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = CharacterAdapter(HeroDetailsResponse) {HeroDetailsResponse ->
                        val intent = DescriptionHeroesActivity.getStartIntent(this@CharacterActivity, HeroDetailsResponse.name, HeroDetailsResponse.description,
                            HeroDetailsResponse.thumbnail.path, HeroDetailsResponse.thumbnail.extension)
                        this@CharacterActivity.startActivity(intent)
                    }
                }
            }
        })

        viewModel.getCharacter()
    }


}
