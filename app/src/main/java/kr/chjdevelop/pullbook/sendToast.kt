package kr.chjdevelop.pullbook

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.sendToast(res: Int) {
    val inflater : LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val layout = inflater.inflate(R.layout.blue_toast, this.findViewById<ViewGroup>(R.id.blue_toast_container))

    val msg = getString(res)

    Toast(this).apply {
        layout.findViewById<TextView>(R.id.tv_toast_message).text = msg
        setGravity(Gravity.BOTTOM,0,100)
        duration = Toast.LENGTH_SHORT
        view = layout
        show()
    }
}

fun Fragment.sendToast(res: Int) {
    this.activity?.sendToast(res)
}