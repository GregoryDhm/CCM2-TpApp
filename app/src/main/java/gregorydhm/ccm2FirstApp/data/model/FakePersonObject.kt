package gregorydhm.ccm2FirstApp.data.model

data class FakePersonObject(
    val gender: String,
    val firstName: String,
    val lastName: String,
)


fun List<FakePersonEntity>.toUi(): List<FakePersonObject> {
    return map { eachEntity ->
        FakePersonObject(
            gender = eachEntity.gender,
            firstName = eachEntity.firstName,
            lastName = eachEntity.lastName,
        )
    }
}
