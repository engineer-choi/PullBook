package kr.chjdevelop.pullbook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_my_book.*
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.MyBook
import kr.chjdevelop.pullbook.data.MyBookDAO
import kr.chjdevelop.pullbook.data.MyBookDatabase
import kr.chjdevelop.pullbook.sendToast
import kr.chjdevelop.pullbook.ui.my_library.MyLibraryActivity

class MyBookActivity : AppCompatActivity() {
    lateinit var toast: Toast
    lateinit var my_book_DB : MyBookDatabase
    lateinit var myBook : MyBook
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_book)
        init()
    }
    private fun init(){
        toast = Toast.makeText(this,"",Toast.LENGTH_SHORT)
        bindDatas()
        setEvent()
    }
    private fun setEvent(){
        //삭제버튼
        rl_delete_btn.setOnClickListener{
            my_book_DB = MyBookDatabase.getInstance(this)!!
            val r = Runnable {
                //데이터 불러오기 작업 할 Runnable객체
                my_book_DB?.myBookDao()?.deleteBook(myBook)
                runOnUiThread{
                    toast.sendToast(this,R.string.deleted)
                    finish()
                }
            }
            val thread = Thread(r)
            thread.start()
        }

        //알람 설정하기
        rl_alarm_btn.setOnClickListener{
            toast.sendToast(this,R.string.test_ment)
        }
    }
    private fun bindDatas(){
        val intent = getIntent()
        myBook = intent.getSerializableExtra("item_book_data") as MyBook
        tv_book_author.text = myBook.author
        tv_book_title.text = myBook.title
        tv_read_date.text = myBook.date
        Glide.with(this).load(myBook.thumbnail).into(img_book)
    }
}
