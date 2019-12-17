package kr.chjdevelop.pullbook.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestObject{
    private const val BASE_URL = "https://dapi.kakao.com"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service : RequestCode = retrofit.create(RequestCode::class.java)
}