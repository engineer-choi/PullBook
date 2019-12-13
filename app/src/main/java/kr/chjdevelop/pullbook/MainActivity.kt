package kr.chjdevelop.pullbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        rl_read_book.setOnClickListener{
            val intent = Intent(this,ReadBookActivity::class.java)
            startActivity(intent)
        }
    }
}
