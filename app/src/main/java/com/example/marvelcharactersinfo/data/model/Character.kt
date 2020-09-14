package com.example.marvelcharactersinfo.data.model

data class Character(

    /*Declarei o model, mesmo não o utilizando de fato, apenas para representar que, em aplicações
      de maior expressão/tamanho, a existencia do mesmo seria de vital importância.
    */
    val name: String,
    val description: String,
    val imagehero: String,
    val extension: String
)
