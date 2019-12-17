package kr.chjdevelop.pullbook.ui.my_library

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.chjdevelop.pullbook.R
import kr.chjdevelop.pullbook.data.SearchItem
import kr.chjdevelop.pullbook.ui.search_and_add.SearchAndAddBookViewHolder

class MyLibrarayAdapter (private val activity : Activity, private val context: Context): RecyclerView.Adapter<MyLibraryViewHolder>(){

    var data = mutableListOf<SearchItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyLibraryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_library,parent,false)
        return MyLibraryViewHolder(
            activity,
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyLibraryViewHolder, position: Int) {
        holder.bind(data[position])
    }
}