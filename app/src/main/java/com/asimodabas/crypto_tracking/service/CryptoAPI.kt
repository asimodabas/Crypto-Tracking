package com.asimodabas.crypto_tracking.service

import com.asimodabas.crypto_tracking.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //API Key : 2187154b76945f2373394aa34f7dc98a

    //https://api.nomics.com/v1/
    //prices?key=2187154b76945f2373394aa34f7dc98a

    @GET("prices?key=2187154b76945f2373394aa34f7dc98a")

    fun getData():Call<List<CryptoModel>>


}