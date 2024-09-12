package gregorydhm.ccm2FirstApp.data.model

import android.util.Log
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FakePersonResponse(
    @Expose
    @SerializedName("results")
    val results: List<FakePersonDto>,
)
data class FakePersonDto(
    /*@Expose
    @SerializedName("gender")
    val gender: String,*/

    @Expose
    @SerializedName("name")
    val name: NameDto,
)
data class NameDto(
    @Expose
    @SerializedName("title")
    val gender: String,

    @Expose
    @SerializedName("first")
    val first: String,

    @Expose
    @SerializedName("last")
    val last: String
)

fun FakePersonResponse.toRoom(): FakePersonEntity? {
    Log.d("toto", "toRoom() called $this")
    val firstPerson = results.firstOrNull() ?: return null
    return FakePersonEntity(
        gender = firstPerson.name.gender,
        firstName = firstPerson.name.first,
        lastName = firstPerson.name.last,
    )
}
