package gregorydhm.ccm2FirstApp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gregorydhm.ccm2FirstApp.data.model.F1RaceWinnerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface F1RaceWinnerDao {

    @Query("SELECT * FROM F1_RACE_WINNER ORDER BY name ASC")
    fun selectAll(): Flow<List<F1RaceWinnerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: F1RaceWinnerEntity)

    @Query("DELETE FROM F1_RACE_WINNER")
    fun deleteAll()
}
