package gregorydhm.ccm2FirstApp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gregorydhm.ccm2FirstApp.data.model.ChuckNorrisEntity
import gregorydhm.ccm2FirstApp.data.model.FakePersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FakePersonDao {


    @Query("SELECT * FROM FAKE_PERSON_TABLE ORDER BY last_name ASC")
    fun selectAll(): Flow<List<FakePersonEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(fakePersonEntity: FakePersonEntity)


    @Query("DELETE FROM FAKE_PERSON_TABLE")
    fun deleteAll()
}
