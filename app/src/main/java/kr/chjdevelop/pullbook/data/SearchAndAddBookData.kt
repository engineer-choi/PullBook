package kr.chjdevelop.pullbook.data

data class SearchAndAddBookData(
   val documents : List<SearchItem>
)

data class SearchItem(
    val title : String,
    val authors : Array<String>,//String 배열로 넘어옴.
    val contents : String,
    val thumbnail : String,//이미지 URL
    val url : String//상세 URL
)