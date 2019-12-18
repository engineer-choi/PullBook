package kr.chjdevelop.pullbook.ui.search_and_add

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.MyBook
import kr.chjdevelop.pullbook.sendToast
import kr.chjdevelop.pullbook.ui.WebViewActivity
import kr.chjdevelop.pullbook.ui.my_library.MyLibraryActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SearchAndAddBookViewHolder (private val activity : Activity, view: View, private val intent : Intent) : RecyclerView.ViewHolder(view) {

    //val rv_homeFind_item: View = view.findViewById(R.id.rv_homeFind)
    val ll_search_and_add_book = view.findViewById<LinearLayout>(R.id.ll_search_and_add_book)
    val img_book = view.findViewById<ImageView>(R.id.img_book)
    val tv_book_title = view.findViewById<TextView>(R.id.tv_book_title)
    val tv_book_summary = view.findViewById<TextView>(R.id.tv_book_summary)
    val tv_book_author = view.findViewById<TextView>(R.id.tv_book_author)
    val btn_add_book = view.findViewById<Button>(R.id.btn_add_book)

    @RequiresApi(Build.VERSION_CODES.O)
    var now = LocalDate.now()
    @RequiresApi(Build.VERSION_CODES.O)
    var now_string = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))

    fun bind(data: MyBook) {
        if (data.thumbnail!!.isEmpty()){
            img_book.setImageResource(R.drawable.no_img)
        }else{
            Glide.with(itemView).load(data.thumbnail).into(img_book)
        }
        tv_book_title.text = data.title
        tv_book_summary.text = data.contents
        val author = data.authors!!.contentToString()
        tv_book_author.text = author
        ll_search_and_add_book.setOnClickListener{
            val specific_intent = Intent(itemView.context,WebViewActivity::class.java)
            itemView.context.startActivity(specific_intent)
        }
        btn_add_book.setOnClickListener{
            val addIntent = Intent(activity,MyLibraryActivity::class.java)
            addIntent.putExtra("title",data.title)
            addIntent.putExtra("contents",data.contents)
            addIntent.putExtra("author",author)
            addIntent.putExtra("thumbnail",data.thumbnail)
            addIntent.putExtra("date",now_string)
            activity.setResult(100,addIntent)
            val toast = Toast.makeText(itemView.context,"",Toast.LENGTH_SHORT)
            val message = R.string.added_sentence
            toast.sendToast(itemView.context,message)
            activity.finish()
        }
    }

}