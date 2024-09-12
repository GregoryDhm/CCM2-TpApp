package gregorydhm.ccm2FirstApp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gregorydhm.ccm2FirstApp.data.model.ChuckNorrisEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChuckNorrisDao {
    @Query("SELECT * FROM chuck_norris_table ORDER BY quote ASC")
    fun selectAll(): Flow<List<ChuckNorrisEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chuckNorrisEntity: ChuckNorrisEntity)

    @Query("DELETE FROM chuck_norris_table")
    fun deleteAll()
}
