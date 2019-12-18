package kr.chjdevelop.pullbook.data

import androidx.room.*
import java.io.Serializable

data class SearchAndAddBookData(
   val documents : List<MyBook>
)

//제목, 저자, 이미지, 날짜, 읽고있는지, 요약
//Room 라이브러리 이용.
@Entity(tableName = "my_book")//Entity어노테이션을 이용해 tableName을 지정해준다(데이터 모델로 보면됨)
class MyBook(@PrimaryKey var id: Long?,//반드시 정의해줘야 하는 PrimaryKey!
             @ColumnInfo(name = "title") var title: String?,//나머지 항목들 추가하면 됨
             @Ignore var authors: Array<String>?,//배열로 넘겨받기 위한 용도
             @ColumnInfo(name = "author") var author: String?,//실제 컬럼에 저장할 데이터 형태
             @ColumnInfo(name = "thumbnail") var thumbnail: String?,
             @ColumnInfo(name = "date") var date: String?,
             @ColumnInfo(name = "reading") var reading: Int,//0이면 읽는중, 1은 완독
             @ColumnInfo(name = "contents") var contents: String?
):Serializable{
    constructor(): this(0,"",null,"","","",0,"")
}//이거 만들었다면 DAO(Database Access Object) 만들어준다.