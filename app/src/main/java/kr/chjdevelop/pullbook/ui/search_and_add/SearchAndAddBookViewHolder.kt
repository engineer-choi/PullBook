package kr.chjdevelop.pullbook.ui.search_and_add

import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.SearchAndAddBookData
import kr.chjdevelop.pullbook.sendToast

class SearchAndAddBookViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    //val rv_homeFind_item: View = view.findViewById(R.id.rv_homeFind)
    val img_book = view.findViewById<ImageView>(R.id.img_book)
    val tv_book_title = view.findViewById<TextView>(R.id.tv_book_title)
    val tv_book_summary = view.findViewById<TextView>(R.id.tv_book_summary)
    val tv_book_author = view.findViewById<TextView>(R.id.tv_book_author)
    val btn_add_book = view.findViewById<Button>(R.id.btn_add_book)

    fun bind(data: SearchAndAddBookData) {
        Glide.with(itemView).load(data.thumbnail).into(img_book)
        tv_book_title.text = data.title
        tv_book_summary.text = data.contents
        tv_book_author.text = data.authors.toString()
        btn_add_book.setOnClickListener{
            val toast = Toast.makeText(itemView.context,"",Toast.LENGTH_SHORT)
            toast.sendToast(itemView.context,"버튼눌렀음")
        }
    }

}