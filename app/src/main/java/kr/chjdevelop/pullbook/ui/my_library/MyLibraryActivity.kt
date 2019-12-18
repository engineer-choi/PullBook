package kr.chjdevelop.pullbook.ui.my_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_my_library.*
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.MyBook
import kr.chjdevelop.pullbook.data.MyBookDatabase
import kr.chjdevelop.pullbook.sendToast
import kr.chjdevelop.pullbook.ui.search_and_add.SearchAndAddBookActivity

class MyLibraryActivity : AppCompatActivity() {

    lateinit var myLibrarayAdapter : MyLibrarayAdapter
    var my_book_list = mutableListOf<MyBook>()

    lateinit var toast : Toast
    lateinit var rv_my_library_reading : RecyclerView
    private var my_book_DB : MyBookDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_library)
        init()

    }
    private fun loadSavedDatas(){
        //DB에 저장한 책 데이터들 다 불러오기
    }
    private fun setDB(){
        //DB의 데이터를 불러올 떄는 메인 스레드가 아닌 서브 스레드가 수행하도록 처리해주어야 한다.
        val r = Runnable {
            //데이터 불러오기 작업 할 Runnable객체
            my_book_list = my_book_DB?.myBookDao()?.getAll()!!
            runOnUiThread{
                if (my_book_list.size!=0) {
                    rv_my_library_reading.visibility= View.VISIBLE
                    tv_add_recommend.visibility = View.GONE
                    Log.d("hj", my_book_list.toString())
                    myLibrarayAdapter.data = my_book_list
                    myLibrarayAdapter.notifyDataSetChanged()
                }
            }
        }
        val thread = Thread(r)
        thread.start()
    }
    private fun init(){
        setAdapter()
        my_book_DB = MyBookDatabase.getInstance(this)
        setDB()
        loadSavedDatas()
        img_add_to_library.setOnClickListener{
            val intent = Intent(this, SearchAndAddBookActivity::class.java)
            startActivityForResult(intent,100)
            toast = Toast.makeText(this,"",Toast.LENGTH_SHORT)
            toast.sendToast(this,R.string.search_book_recommend)
        }
    }
    private fun setAdapter(){
        myLibrarayAdapter = MyLibrarayAdapter(this,this)
        rv_my_library_reading = findViewById<RecyclerView>(R.id.rv_my_library_reading)
        rv_my_library_reading.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_my_library_reading.adapter = myLibrarayAdapter
        //데이터 저장된거 불러와서 어댑터에 추가작업 필요
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100&&data!=null){
            //서재에 해당 책 추가
            val myBook = MyBook(
                id = null,
                title = data!!.getStringExtra("title"),
                authors = null,
                author = data!!.getStringExtra("author"),
                contents = data!!.getStringExtra("contents"),
                thumbnail = data!!.getStringExtra("thumbnail"),
                date = data!!.getStringExtra("date"),
                reading = 0
            )
            myLibrarayAdapter.data.add(myBook)
            addToDataBase(myBook)
            myLibrarayAdapter.notifyDataSetChanged()
            rv_my_library_reading.visibility= View.VISIBLE
            tv_add_recommend.visibility = View.GONE
        }
    }
    private fun addToDataBase(myBook: MyBook){
        val r = Runnable {
            //데이터 불러오기 작업 할 Runnable객체
            my_book_DB?.myBookDao()?.insert(myBook)
        }
        val thread = Thread(r)
        thread.start()
    }

    override fun onResume() {
        setDB()
        super.onResume()
    }

    override fun onDestroy() {
        MyBookDatabase.destroyInstance()
        my_book_DB = null
        super.onDestroy()
    }
}
