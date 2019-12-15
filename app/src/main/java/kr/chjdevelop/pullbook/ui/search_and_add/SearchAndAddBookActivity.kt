package kr.chjdevelop.pullbook.ui.search_and_add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_search_and_add_book.*
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.Dummy
import kr.chjdevelop.pullbook.data.SearchAndAddBookData

class SearchAndAddBookActivity : AppCompatActivity() {

    lateinit var searchAndAddBookAdapter : SearchAndAddBookAdapter
    lateinit var rv_search_book : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_and_add_book)
        init()
    }
    private fun init(){
        et_search_book.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //검색요청하기
            }

        })
        searchAndAddBookAdapter = SearchAndAddBookAdapter(this)
        rv_search_book = findViewById(R.id.rv_search_book)
        rv_search_book.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_search_book.adapter = searchAndAddBookAdapter
        setDummy()
        searchAndAddBookAdapter.notifyDataSetChanged()
    }
    private fun setDummy(){
        searchAndAddBookAdapter.data = listOf(
            SearchAndAddBookData(
                title = "미움받을 용기",
                authors = ArrayList<Dummy>(),
                contents = "모든 사람은 지금 당장 행복해질 수 있다.",
                thumbnail = "https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F1467038"
            ),
            SearchAndAddBookData(
                title = "미움받을 용기",
                authors = ArrayList<Dummy>(),
                contents = "모든 사람은 지금 당장 행복해질 수 있다.",
                thumbnail = "https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F1467038"
            ),
            SearchAndAddBookData(
                title = "미움받을 용기",
                authors = ArrayList<Dummy>(),
                contents = "모든 사람은 지금 당장 행복해질 수 있다.",
                thumbnail = "https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F1467038"
            )
        )
    }
}
