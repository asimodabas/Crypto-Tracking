package com.asimodabas.crypto_tracking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asimodabas.crypto_tracking.R
import com.asimodabas.crypto_tracking.model.CryptoModel
import com.asimodabas.crypto_tracking.service.CryptoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var cryptoModels: ArrayList<CryptoModel>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //API Key : 2187154b76945f2373394aa34f7dc98a
        //https://api.nomics.com/v1/prices?key=2187154b76945f2373394aa34f7dc98a
        //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

        loadData()
    }

    fun loadData() {

        val retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(CryptoAPI::class.java)
        val call = service.getData()


        call.enqueue(object : Callback<List<CryptoModel>> {

            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        cryptoModels = ArrayList(it)

                        for (cryptoModel: CryptoModel in cryptoModels!!) {
                            println(cryptoModel.currency)
                            println(cryptoModel.price)
                        }

                    }
                }
            }

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

}