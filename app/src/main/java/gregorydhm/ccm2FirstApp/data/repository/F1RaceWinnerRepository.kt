package gregorydhm.ccm2FirstApp.data.repository

import F1RaceWinnerObject
import gregorydhm.ccm2FirstApp.architecture.CustomApplication
import gregorydhm.ccm2FirstApp.data.model.toRoomObject
import gregorydhm.ccm2FirstApp.data.model.toUi
import gregorydhm.ccm2FirstApp.ui.model.F1RaceWinnerUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class F1RaceWinnerRepository {
    private val f1RaceWinnerDao =
        CustomApplication.instance.mApplicationDatabase.f1RaceWinnerDao()

    fun selectAllF1RaceWinner(): Flow<List<F1RaceWinnerUi.Item>> {
        return f1RaceWinnerDao.selectAll().map {
            it.toUi()
        }
    }

    fun insertF1RaceWinner(F1RaceWinnerObject: F1RaceWinnerUi.Item) {
        f1RaceWinnerDao.insert(F1RaceWinnerObject.toRoomObject())
    }

    fun deleteAllF1RaceWinner() {
        f1RaceWinnerDao.deleteAll()
    }

    fun PopulateF12024Season(): List<F1RaceWinnerObject>{
        return listOf(
            F1RaceWinnerObject(name = "Max Verstappen","Bahrain", laps = 57, domicile = false),
            F1RaceWinnerObject(name = "Max Verstappen","Saudi Arabia", laps = 50, domicile = false),
            F1RaceWinnerObject(name = "Carlos Sainz","Australia", laps = 58, domicile = false),
            F1RaceWinnerObject(name = "Max Verstappen","Japan", laps = 53, domicile = false),
            F1RaceWinnerObject(name = "Max Verstappen","China", laps = 56, domicile = false),
            F1RaceWinnerObject(name = "Lando Norris","Miami", laps = 57, domicile = false),
            F1RaceWinnerObject(name = "Max Verstappen","Emilia-Romagna", laps = 63, domicile = false),
            F1RaceWinnerObject(name = "Charles Leclerc","Monaco", laps = 78, domicile = true),
            F1RaceWinnerObject(name = "Max Verstappen","Canada", laps = 70, domicile = false),
            F1RaceWinnerObject(name = "Max Verstappen","Spain", laps = 66, domicile = false),
            F1RaceWinnerObject(name = "George Russell","Austria", laps = 71, domicile = false),
            F1RaceWinnerObject(name = "Lewis Hamilton","Great Britain", laps = 52, domicile = true),
            F1RaceWinnerObject(name = "Oscar Piastri","Hungary", laps = 70, domicile = false),
            F1RaceWinnerObject(name = "Lewis Hamilton","Belgium", laps = 44, domicile = false),
            F1RaceWinnerObject(name = "Lando Norris","Netherlands", laps = 72, domicile = false),
            F1RaceWinnerObject(name = "Charles Leclerc","Monza", laps = 53, domicile = false),
        )
    }
}