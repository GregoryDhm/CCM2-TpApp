package gregorydhm.ccm2FirstApp.data.remote

import gregorydhm.ccm2FirstApp.data.model.FakePersonResponse
import retrofit2.http.GET

interface FakePersonEndpoint {
    @GET("api")
    suspend fun getFakePerson() : FakePersonResponse
}
