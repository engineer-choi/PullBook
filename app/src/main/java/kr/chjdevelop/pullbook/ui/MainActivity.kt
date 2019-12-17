package kr.chjdevelop.pullbook.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.ui.my_library.MyLibraryActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        rl_read_book.setOnClickListener{
            val intent = Intent(this, ReadBookActivity::class.java)
            startActivity(intent)
        }
        rl_library.setOnClickListener{
            val intent = Intent(this, MyLibraryActivity::class.java)
            startActivity(intent)
        }
    }
}
