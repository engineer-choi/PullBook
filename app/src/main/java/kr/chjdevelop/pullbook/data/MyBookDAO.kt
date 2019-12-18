package kr.chjdevelop.pullbook.data

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

//https://developer.android.com/training/data-storage/room/accessing-data 참고할 것
@Dao
interface MyBookDAO{
    @Query("SELECT * FROM my_book")
    fun getAll() : MutableList<MyBook>

    @Insert(onConflict = REPLACE)//insert할 때 PrimaryKey가 겹치면 덮어쓰겠다는 말
    fun insert(myBook: MyBook)

    @Update
    fun update(myBook: MyBook)

    @Delete
    fun deleteBook(myBook: MyBook)
}//됬으면 MyBookDatabase 만들어야함.