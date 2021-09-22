package prueba.tecnica.openbank.data.datasource.common

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import prueba.tecnica.openbank.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitCommonApiClientGenerator() : ComonApiClientGenerator {

    private val retrofit: Retrofit

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        val builder = Retrofit.Builder()
        builder.baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(jsonConverter())
            .client(okHttpClient)

        retrofit = builder.build()
    }

    private fun jsonConverter(): GsonConverterFactory {
        val gson = GsonBuilder()
            .enableComplexMapKeySerialization()
            .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
            .create()

        return GsonConverterFactory.create(gson)
    }

    override fun <T> generatedApi(service: Class<T>): T = retrofit.create(service)
}