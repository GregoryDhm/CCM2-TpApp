package gregorydhm.ccm2FirstApp.ui.model

sealed interface ItemUi {
    data class MyAndroidObject(
        val versionName: String,
        val versionNumber: String,
    ) : ItemUi

    data class Header(
        val title: String,
    ) : ItemUi
}