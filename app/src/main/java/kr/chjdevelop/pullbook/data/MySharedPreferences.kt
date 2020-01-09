package kr.chjdevelop.pullbook.data

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences (context: Context){
    val PREF_KEY_MY_PHONE = "user_phone"
    val PREFS_FILENAME = "prefs"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME,0)
    val editor = prefs.edit()
    var facebook_token : Long
        get() = prefs.getLong(PREF_KEY_MY_PHONE,0)
        set(value) = editor.putLong(PREF_KEY_MY_PHONE, value).apply()
}