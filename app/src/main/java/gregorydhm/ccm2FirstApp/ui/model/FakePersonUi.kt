package gregorydhm.ccm2FirstApp.ui.model

import gregorydhm.ccm2FirstApp.data.model.FakePersonObject

data class FakePersonUi(
    val gender: String,
    val firstName: String,
    val lastName: String,
)

fun List<FakePersonObject>.toUi() : List<FakePersonUi> {
    return map { item ->
        FakePersonUi(
            gender = item.gender,
            firstName = item.firstName,
            lastName = item.lastName,
        )
    }
}
