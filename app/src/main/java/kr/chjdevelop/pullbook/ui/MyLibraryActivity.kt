package kr.chjdevelop.pullbook.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_my_library.*
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.sendToast
import kr.chjdevelop.pullbook.ui.search_and_add.SearchAndAddBookActivity

class MyLibraryActivity : AppCompatActivity() {
    lateinit var toast : Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_library)
        init()

    }
    private fun init(){
        img_add_to_library.setOnClickListener{
            val intent = Intent(this, SearchAndAddBookActivity::class.java)
            startActivity(intent)
            toast = Toast.makeText(this,"",Toast.LENGTH_SHORT)
            toast.sendToast(this,"읽은 책을 검색하세요!")
        }
    }

}
