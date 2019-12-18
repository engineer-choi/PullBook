package kr.chjdevelop.pullbook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyBook::class], version = 1)
abstract class MyBookDatabase : RoomDatabase(){
    abstract fun myBookDao(): MyBookDAO

    companion object{
        private var INSTANCE: MyBookDatabase? = null

        fun getInstance(context: Context): MyBookDatabase? {//해당 액티비티에서 database 호출하여 사용하기 위함
            if (INSTANCE == null) {
                synchronized(MyBookDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyBookDatabase::class.java, "my_book.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance() {//썼던 객체를 삭제할 수 있도록 하는 메소드
            INSTANCE = null
        }
    }
}