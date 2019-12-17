package kr.chjdevelop.pullbook.network

import kr.chjdevelop.pullbook.data.SearchAndAddBookData
import retrofit2.Call
import retrofit2.http.Headers

import retrofit2.http.GET
import retrofit2.http.Query

interface RequestCode{
    @Headers("Authorization: KakaoAK b31fbd7c55b206dd86ce796b316362d0")
    @GET("/v3/search/book")
    fun requestSearchBook(
        @Query("query")bookTitle : String
    ) : Call<SearchAndAddBookData>
}