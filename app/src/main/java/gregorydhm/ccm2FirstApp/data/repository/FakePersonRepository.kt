package gregorydhm.ccm2FirstApp.data.repository

import gregorydhm.ccm2FirstApp.architecture.CustomApplication
import gregorydhm.ccm2FirstApp.architecture.RetrofitBuilder
import gregorydhm.ccm2FirstApp.data.model.FakePersonObject
import gregorydhm.ccm2FirstApp.data.model.toRoom
import gregorydhm.ccm2FirstApp.data.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FakePersonRepository {
    private val fakePersonDao = CustomApplication.instance.mApplicationDatabase.fakePersonDao()

    suspend fun fetchData() {
        RetrofitBuilder.getFakePerson().getFakePerson().toRoom()?.let { fakePersonDao.insert(it) }
    }


    fun deleteAll() {
        fakePersonDao.deleteAll()
    }


    fun selectAll(): Flow<List<FakePersonObject>> {
        return fakePersonDao.selectAll().map { list ->
            list.toUi()
        }
    }
}