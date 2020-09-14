package com.example.marvelcharactersinfo.presentation.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharactersinfo.R
import com.example.marvelcharactersinfo.data.response.HeroDetailsResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter(private val character : List<HeroDetailsResponse>,
//Fazendo o callback para a DescriptionHeroesActivity
    private val onItemClickListener: ((hero_description : HeroDetailsResponse) -> Unit)
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent,false)
        return CharacterViewHolder(view, onItemClickListener)
    }

    override fun getItemCount() = character.count()


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindView(character[position])
    }

    class CharacterViewHolder(
        view: View,
        private val onItemClickListener: (hero_description: HeroDetailsResponse) -> Unit) : RecyclerView.ViewHolder(view) {

        private val titulo = view.textTitulo

        fun bindView(character: HeroDetailsResponse){
            titulo.text = character.name
            val url = "${character.thumbnail.path}/standard_large.${character.thumbnail.extension}"
                .split(":")
                Picasso.get().load("https:" + url[1]).into(itemView.imageFilme)

            itemView.setOnClickListener {
                onItemClickListener.invoke(character)
            }
        }
    }
}