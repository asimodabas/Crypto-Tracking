package com.asimodabas.crypto_tracking.service

import com.asimodabas.crypto_tracking.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //API Key : 2187154b76945f2373394aa34f7dc98a

    //https://raw.githubusercontent.com
    //atilsamancioglu/K21-JSONDataSet/master/crypto.json

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")

    fun getData():Call<List<CryptoModel>>


}