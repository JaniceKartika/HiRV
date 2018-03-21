package com.bukalapak.hirv.product

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by janice on 3/21/18.
 */

interface ProductAPIInterface {
    @GET("omniscience/v2.json")
    fun getData(
            @Query("user") user: String,
            @Query("key") key: String,
            @Query("word") word: String
    ): Call<DataModel>

    companion object Factory {
        fun create(): ProductAPIInterface {
            return Retrofit.Builder()
                    .baseUrl("https://api.bukalapak.com/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ProductAPIInterface::class.java)
        }
    }
}
