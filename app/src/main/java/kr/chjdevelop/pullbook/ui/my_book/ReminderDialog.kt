package kr.chjdevelop.pullbook.ui.my_book

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kr.chjdevelop.pullbook.R

class ReminderDialog(context : Context, title : String, balance : String, imgId : Int, btnString : String, intBtn : Int, lineColor : Int, listener : View.OnClickListener) : Dialog(context) {
    private lateinit var txtDialogTitle : TextView
    private lateinit var imgDialog : ImageView
    private lateinit var btnConfirm : Button


    private var strTitle = title
    private var intImgId = imgId
    private var strConfirm = btnString


    override fun onCreate(savedInstanceState : Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_reminder_my_book)




        txtDialogTitle.setText(strTitle)
        imgDialog.setImageResource(intImgId)
        btnConfirm.setText(strConfirm)


    }
}