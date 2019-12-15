package kr.chjdevelop.pullbook

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

fun Toast.sendToast(context : Context, message : String){
    val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val layout = inflater.inflate(R.layout.blue_toast, (context as Activity).findViewById<ViewGroup>(R.id.blue_toast_container))

    layout.findViewById<TextView>(R.id.tv_toast_message).text = message
    setGravity(Gravity.BOTTOM,0,50)
    duration = Toast.LENGTH_SHORT
    view = layout
    show()
}