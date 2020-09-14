###Introdução

O projeto tem como objetivo listar e mostrar informações acerca dos Herois da Marvel.

###Instalação
Para que o aplicativo funcione normalmente, faça o clone do repositório e adicione as seguintes dependências ao seu código:

Link para clone do repositório.
'''
$ git clone https://github.com/GabrielsSouza/Marvel.git


Dependências necessárias para o funcionamento regular do app
'''
implementation 'com.android.support:recyclerview-v7:30.0.0'

    implementation 'android.arch.lifecycle:extensions:1.1.1'

    implementation 'com.squareup.retrofit2:retrofit:2.6.0'
    implementation 'com.squareup.retrofit2:converter-moshi:2.6.0'

    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.8.0")
    implementation "com.squareup.moshi:moshi:1.8.0"

    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'

    implementation 'com.squareup.picasso:picasso:2.71828'
    
