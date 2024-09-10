package gregorydhm.ccm2FirstApp.ui.model

sealed interface F1DriverUi {
    data class f1DriverObject(
        val name: String,
        val victoire: String,
        val nbVictoire: Int,
        val actif: Boolean,
    ) : F1DriverUi

    data class Header(
        val title: String,
    ) : F1DriverUi
}