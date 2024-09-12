package gregorydhm.ccm2FirstApp.ui.model

import F1RaceWinnerObject

sealed interface F1RaceWinnerUi {
    data class Item(
        val name: String,
        val Circuit: String,
        val laps: Int,
        val domicile: Boolean,
    ) : F1RaceWinnerUi

    data class Header(
        val title: String,
    ) : F1RaceWinnerUi
    data class Footer(
        val footer: Int,
    ) : F1RaceWinnerUi
    data class FooterTotal(
        val footerTotal: Int,
    ) : F1RaceWinnerUi
}
fun List<F1RaceWinnerObject>.toUi(): List<F1RaceWinnerUi.Item> {
    return map { currentDriverObject ->
        F1RaceWinnerUi.Item(
            name = currentDriverObject.name,
            Circuit = currentDriverObject.circuit,
            laps = currentDriverObject.laps,
            domicile = currentDriverObject.domicile,
        )
    }
}
