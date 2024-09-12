package gregorydhm.ccm2FirstApp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FAKE_PERSON_TABLE")
data class FakePersonEntity(
    @ColumnInfo(name = "gender")
    val gender: String,

    @ColumnInfo(name = "first_name")
    val firstName: String,

    @ColumnInfo(name = "last_name")
    val lastName: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
