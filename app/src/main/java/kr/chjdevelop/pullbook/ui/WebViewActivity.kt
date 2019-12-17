package kr.chjdevelop.pullbook.ui

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kr.chjdevelop.pullbook.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        init()
    }
    private fun init(){
        val intent = intent
        val urlData = intent.getStringExtra("url")
        Log.d("hj",urlData)
        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
    }


}

