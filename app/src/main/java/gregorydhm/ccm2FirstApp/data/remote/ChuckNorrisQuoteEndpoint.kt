package gregorydhm.ccm2FirstApp.data.remote

import gregorydhm.ccm2FirstApp.data.model.ChuckNorrisDto
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {
    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisDto
}