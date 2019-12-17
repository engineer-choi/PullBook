package kr.chjdevelop.pullbook.ui.search_and_add

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_search_and_add_book.*
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.network.RequestObject
import kr.chjdevelop.pullbook.network.enqueue

class SearchAndAddBookActivity : AppCompatActivity() {

    lateinit var searchAndAddBookAdapter : SearchAndAddBookAdapter
    lateinit var rv_search_book : RecyclerView
    val requestService = RequestObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_and_add_book)
        init()
    }
    private fun init(){
        val intent = intent
        setResources()
        setRecyclerView(intent)
    }
    private fun setRecyclerView(intent : Intent){
        searchAndAddBookAdapter = SearchAndAddBookAdapter(this,this,intent)
        rv_search_book = findViewById(R.id.rv_search_book)
        rv_search_book.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_search_book.adapter = searchAndAddBookAdapter
    }
    private fun setResources(){
        et_search_book.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //검색요청하기
                requestService.service.requestSearchBook(s.toString()).enqueue{
                        response ->
                    if(response.isSuccessful){
                        val responseDatas = response.body()!!
                        searchAndAddBookAdapter.data = responseDatas.documents
                        searchAndAddBookAdapter.notifyDataSetChanged()
                    }

                }
            }
        })
    }
}
