package kr.chjdevelop.pullbook.ui.search_and_add

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.SearchAndAddBookData

class SearchAndAddBookAdapter (private val context: Context): RecyclerView.Adapter<SearchAndAddBookViewHolder>(){

    var data = listOf<SearchAndAddBookData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAndAddBookViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_search_and_add_book,parent,false)
        return SearchAndAddBookViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SearchAndAddBookViewHolder, position: Int) {
        holder.bind(data[position])
    }
}