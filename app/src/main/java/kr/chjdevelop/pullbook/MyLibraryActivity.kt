package kr.chjdevelop.pullbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_my_library.*

class MyLibraryActivity : AppCompatActivity() {
    val toast = Toast.makeText(this,"",Toast.LENGTH_SHORT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_library)
        init()

    }
    private fun init(){
        img_add_to_library.setOnClickListener{
            val intent = Intent(this,SearchAndAddBookActivity::class.java)
            startActivity(intent)
            toast.sendToast(this,"가나다라")
        }
    }

}
