package kr.chjdevelop.pullbook.ui.my_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_my_library.*
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.SearchItem
import kr.chjdevelop.pullbook.sendToast
import kr.chjdevelop.pullbook.ui.search_and_add.SearchAndAddBookActivity

class MyLibraryActivity : AppCompatActivity() {
    lateinit var toast : Toast
    lateinit var myLibrarayAdapter : MyLibrarayAdapter
    lateinit var rv_my_library : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_library)
        init()

    }
    private fun init(){
        setAdapter()

        img_add_to_library.setOnClickListener{
            val intent = Intent(this, SearchAndAddBookActivity::class.java)
            startActivityForResult(intent,100)
            toast = Toast.makeText(this,"",Toast.LENGTH_SHORT)
            toast.sendToast(this,R.string.search_book_recommend)
        }
    }
    private fun setAdapter(){
        myLibrarayAdapter = MyLibrarayAdapter(this)
        val rv_my_library = findViewById<RecyclerView>(R.id.rv_my_library)
        rv_my_library.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_my_library.adapter = myLibrarayAdapter
        //데이터 저장된거 불러와서 어댑터에 추가작업 필요
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100&&data!=null){
            //서재에 해당 책 추가
            myLibrarayAdapter.data.add(
                SearchItem(
                title = data!!.getStringExtra("title"),
                authors = data!!.getStringArrayExtra("authors"),
                contents = data!!.getStringExtra("contents"),
                thumbnail = data!!.getStringExtra("thumbnail"),
                url = "1"
            ))
            myLibrarayAdapter.notifyDataSetChanged()
        }
    }

}
