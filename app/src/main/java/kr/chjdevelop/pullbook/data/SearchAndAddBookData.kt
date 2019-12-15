package kr.chjdevelop.pullbook.data

data class SearchAndAddBookData(
    val title : String,
    val authors : List<Dummy>,
    val contents : String,
    val thumbnail : String//이미지 URL
)