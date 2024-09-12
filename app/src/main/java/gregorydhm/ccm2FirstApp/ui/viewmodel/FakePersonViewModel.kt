package gregorydhm.ccm2FirstApp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gregorydhm.ccm2FirstApp.data.repository.FakePersonRepository
import gregorydhm.ccm2FirstApp.ui.model.FakePersonUi
import gregorydhm.ccm2FirstApp.ui.model.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FakePersonViewModel : ViewModel() {
    private val fakePersonRepository: FakePersonRepository by lazy { FakePersonRepository() }
    private val _quotes: Flow<List<FakePersonUi>>
        get() = fakePersonRepository.selectAll().map { list ->
            list.toUi()
        }
    val quote = _quotes
    fun insertNewFakePerson() {
        viewModelScope.launch(Dispatchers.IO) {
            fakePersonRepository.fetchData()
        }
    }
    fun deleteAllPerson() {
        viewModelScope.launch(Dispatchers.IO) {
            fakePersonRepository.deleteAll()
        }
    }
}
