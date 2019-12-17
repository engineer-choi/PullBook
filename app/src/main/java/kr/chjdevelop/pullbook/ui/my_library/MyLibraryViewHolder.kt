package kr.chjdevelop.pullbook.ui.my_library

import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.SearchItem

class MyLibraryViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    //val rv_homeFind_item: View = view.findViewById(R.id.rv_homeFind)
    val img_book = view.findViewById<ImageView>(R.id.img_book)
    val tv_book_title = view.findViewById<TextView>(R.id.tv_book_title)
    val tv_book_author = view.findViewById<TextView>(R.id.tv_book_author)

    fun bind(data: SearchItem) {
        if (data.thumbnail.isEmpty()){
            img_book.setImageResource(R.drawable.no_img)
        }else{
            Glide.with(itemView).load(data.thumbnail).into(img_book)
        }
        tv_book_title.text = data.title
        tv_book_author.text = data.authors.contentToString()
    }

}