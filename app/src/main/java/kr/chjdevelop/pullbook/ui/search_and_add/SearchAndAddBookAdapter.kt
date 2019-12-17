package kr.chjdevelop.pullbook.ui.search_and_add

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.SearchItem

class SearchAndAddBookAdapter (private val activity: Activity, private val context: Context, private val intent : Intent): RecyclerView.Adapter<SearchAndAddBookViewHolder>(){

    var data = listOf<SearchItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAndAddBookViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_search_and_add_book,parent,false)
        return SearchAndAddBookViewHolder(
            activity,
            view,
            intent
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SearchAndAddBookViewHolder, position: Int) {
        holder.bind(data[position])
    }
}