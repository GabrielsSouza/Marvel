package com.example.marvelcharactersinfo.presentation.description

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelcharactersinfo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description_heroes.*
import kotlinx.android.synthetic.main.activity_description_heroes.toolbarMain
import kotlinx.android.synthetic.main.activity_personagens.*
import java.security.AccessControlContext

class DescriptionHeroesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_heroes)

        toolbarMain.title = getString(R.string.app_name)
        setSupportActionBar(toolbarMain)

        val name = intent.getStringExtra("CHAR_NAME")
        val description = intent.getStringExtra("CHAR_DESCRIPTION")
        val path = intent.getStringExtra("CHAR_IMG_PATH")
        val extension = intent.getStringExtra("CHAR_IMAGE_EXTENSION")

        textNameHero.text = name
        textDescription.text = description

        var url = "$path/standard_large.${extension}".split(":")
        Picasso.get().load("https:"+url[1]).into(imageDescription)
    }

    companion object {
        fun getStartIntent(
            context: Context, heroName: String, heroDescription: String,
            heroImgPath: String, heroImgExtension: String): Intent {
            return Intent(context, DescriptionHeroesActivity::class.java).apply {
                putExtra("CHAR_NAME" , heroName)
                putExtra("CHAR_DESCRIPTION" , heroDescription)
                putExtra("CHAR_IMG_PATH" , heroImgPath)
                putExtra("CHAR_IMAGE_EXTENSION" , heroImgExtension)
            }
        }
    }
}
