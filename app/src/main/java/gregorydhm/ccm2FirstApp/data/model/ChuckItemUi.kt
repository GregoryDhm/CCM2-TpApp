package gregorydhm.ccm2FirstApp.data.model

data class ChuckItemUi(
    val quote: String,
    val iconUrl: String,
)

fun List<ChuckNorrisObject>.toUi() : List<ChuckItemUi> {
    return map { item ->
        ChuckItemUi(
            quote = item.title,
            iconUrl = item.url,
        )
    }
}
