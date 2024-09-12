package gregorydhm.ccm2FirstApp.architecture

import com.google.gson.GsonBuilder
import gregorydhm.ccm2FirstApp.data.remote.ChuckNorrisQuoteEndpoint
import gregorydhm.ccm2FirstApp.data.remote.FakePersonEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
    fun getChuckNorrisQuote(): ChuckNorrisQuoteEndpoint = retrofit.create(ChuckNorrisQuoteEndpoint::class.java)

    private val retrofitFakePerson: Retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
    fun getFakePerson(): FakePersonEndpoint = retrofitFakePerson.create(FakePersonEndpoint::class.java)
}
