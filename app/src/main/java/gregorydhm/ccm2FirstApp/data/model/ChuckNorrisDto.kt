package gregorydhm.ccm2FirstApp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChuckNorrisDto(
    @Expose
    @SerializedName("value")
    val quote: String,


    @Expose
    @SerializedName("icon_url")
    val iconUrl: String
)

fun ChuckNorrisDto.toRoom(): ChuckNorrisEntity {
    return ChuckNorrisEntity(
        quote = quote,
        iconUrl = iconUrl
    )
}

@Entity(tableName = "chuck_norris_table")
data class ChuckNorrisEntity(
    @ColumnInfo(name = "quote")
    val quote: String,


    @ColumnInfo(name = "icon")
    val iconUrl: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
