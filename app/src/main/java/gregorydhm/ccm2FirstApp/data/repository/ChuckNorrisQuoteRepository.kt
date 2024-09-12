package gregorydhm.ccm2FirstApp.data.repository

import gregorydhm.ccm2FirstApp.architecture.CustomApplication
import gregorydhm.ccm2FirstApp.architecture.RetrofitBuilder
import gregorydhm.ccm2FirstApp.data.model.ChuckNorrisObject
import gregorydhm.ccm2FirstApp.data.model.toRoom
import gregorydhm.ccm2FirstApp.data.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChuckNorrisQuoteRepository {
    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()


    suspend fun fetchData() {
        chuckNorrisDao.insert(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }

    fun deleteAll() {
        chuckNorrisDao.deleteAll()
    }

    fun selectAll(): Flow<List<ChuckNorrisObject>> {
        return chuckNorrisDao.selectAll().map { list ->
            list.toUi()
        }
    }


}