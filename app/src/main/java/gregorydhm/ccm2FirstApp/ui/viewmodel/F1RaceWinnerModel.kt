package gregorydhm.ccm2FirstApp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gregorydhm.ccm2FirstApp.data.repository.F1RaceWinnerRepository
import gregorydhm.ccm2FirstApp.ui.model.F1RaceWinnerUi
import gregorydhm.ccm2FirstApp.ui.model.ItemUi
import gregorydhm.ccm2FirstApp.ui.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

class F1RaceWinnerModel : ViewModel() {


    // Variable mutable en privée signifie que personne peut modifier le contenu à part le ViewModel
    // lui même. C'est un pattern important à respecter
    private val _F1DriverList = MutableStateFlow<List<F1RaceWinnerUi>>(emptyList())


    // On rend accessible uniquement en lecture la valeur de la variable mutable afin de bloquer l'accès
    val f1DriverList: StateFlow<List<F1RaceWinnerUi>> get() = _F1DriverList.asStateFlow()

    private val f1RaceWinnerRepository: F1RaceWinnerRepository by lazy { F1RaceWinnerRepository() }

    private val _f1RaceWinnerList: Flow<List<F1RaceWinnerUi>>
        get() = f1RaceWinnerRepository.selectAllF1RaceWinner().map { f1 ->
            f1.groupBy { f1 ->
                f1.name
            } .flatMap {
                buildList {
                    add(F1RaceWinnerUi.Header(
                        title = it.key, // versionName
                    ))
                    addAll(it.value)
                    add(
                        F1RaceWinnerUi.Footer(it.value.size)
                    )
                }
            }
        }
    // On rend accessible uniquement en lecture la valeur de la variable mutable afin de bloquer l'accès
    val f1RaceWinnerList : Flow<List<F1RaceWinnerUi>> get() = _f1RaceWinnerList

    /*init {
        // Code exécuté quand le VM est instancié
        viewModelScope.launch(Dispatchers.IO) {
            // On exécute dans un petit thread dédié à Input/Output le fait de générer la liste
            _F1DriverList.emit(populateMyF1DriversList())
        }
    }*/

    fun insertF1DriverWinRace() {
        viewModelScope.launch(Dispatchers.IO) {
            val random = Random.nextInt(0, 20)
            val tours = Random.nextInt(0, 70)
            val circuit = Random.nextInt(0, 25)
            f1RaceWinnerRepository.insertF1RaceWinner(
                F1RaceWinnerUi.Item("Pilote $random", "Circuit $circuit", tours, false)
            )
        }
    }


    fun deleteAllF1RaceWinner() {
        viewModelScope.launch(Dispatchers.IO) {
            f1RaceWinnerRepository.deleteAllF1RaceWinner()
        }
    }

    private fun populateMyF1DriversList(): MutableList<F1RaceWinnerUi> {
        var count = 0
        val result = mutableListOf<F1RaceWinnerUi>()
        f1RaceWinnerRepository.PopulateF12024Season().groupBy { f1DriverObject ->
            f1DriverObject.name
        }.forEach {
            result.add(
                F1RaceWinnerUi.Header(
                    title = it.key,
                )
            )
            result.addAll(it.value.toUi())
            count+=it.value.size
            result.add(
                F1RaceWinnerUi.Footer(it.value.size)
            )
        }
        result.add(
            F1RaceWinnerUi.FooterTotal(count)
        )
        return result;
    }
}
