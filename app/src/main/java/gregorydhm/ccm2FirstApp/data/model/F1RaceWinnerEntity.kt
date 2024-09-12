package gregorydhm.ccm2FirstApp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import gregorydhm.ccm2FirstApp.ui.model.F1RaceWinnerUi

@Entity(tableName = "F1_RACE_WINNER")
data class F1RaceWinnerEntity(

    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "circuit")
    val circuit: String,
    @ColumnInfo(name = "laps")
    val laps: Int,
    @ColumnInfo(name = "domicile")
    val domicile: Boolean,

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
fun F1RaceWinnerUi.Item.toRoomObject(): F1RaceWinnerEntity {
    return F1RaceWinnerEntity(
        name = name,
        circuit = Circuit,
        laps = laps,
        domicile = domicile
    )
}


fun List<F1RaceWinnerEntity>.toUi(): List<F1RaceWinnerUi.Item> {
    return map { eachItem ->
        F1RaceWinnerUi.Item(
            name=eachItem.name,
            Circuit=eachItem.circuit,
            laps=eachItem.laps,
            domicile=eachItem.domicile,
        )
    }
}
