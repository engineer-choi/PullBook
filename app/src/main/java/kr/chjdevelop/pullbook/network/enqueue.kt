package kr.chjdevelop.pullbook.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun<T> Call<T>.enqueue(
    onFailure: (Throwable) -> Unit = { Log.e("hj", "error : $it") },
    onResponse: (response: Response<T>) -> Unit = {}
) {
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            onFailure(t)
        }
        override fun onResponse(call: Call<T>, response: Response<T>) {
            onResponse(response)
        }
    })
}