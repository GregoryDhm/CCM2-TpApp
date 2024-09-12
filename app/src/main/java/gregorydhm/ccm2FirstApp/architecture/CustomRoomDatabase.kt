package gregorydhm.ccm2FirstApp.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import gregorydhm.ccm2FirstApp.data.dao.ChuckNorrisDao
import gregorydhm.ccm2FirstApp.data.dao.F1RaceWinnerDao
import gregorydhm.ccm2FirstApp.data.dao.FakePersonDao
import gregorydhm.ccm2FirstApp.data.model.ChuckNorrisEntity
import gregorydhm.ccm2FirstApp.data.model.F1RaceWinnerEntity
import gregorydhm.ccm2FirstApp.data.model.FakePersonEntity


@Database(
    entities = [
        F1RaceWinnerEntity::class,
        ChuckNorrisEntity::class,
        FakePersonEntity::class
               ],
    version = 3,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun f1RaceWinnerDao(): F1RaceWinnerDao
    abstract fun chuckNorrisDao(): ChuckNorrisDao
    abstract fun fakePersonDao(): FakePersonDao
}
