package com.example.forecastmvvm.data

import com.example.forecastmvvm.data.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "23d42c7f8d5cd0899288bcc4687673ec"
const val BASE_URL = "http://api.weatherstack.com/"

// http://api.weatherstack.com/current?access_key=23d42c7f8d5cd0899288bcc4687673ec&query=Toulouse&Lang=en

/**
 * Interface qui couvre les différentes urls a appeler pour recevoir les données
 * @Query pour passer des paramètres dans l'url
 * languageCode automatique en french
 */
interface ApixuWeatherApiService {

    // obtenir la météo actuelle
    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String,
        @Query("lang") languageCode: String = "fr"
    ) : Deferred<CurrentWeatherResponse>

    /**
     * Aller récupérer les données depuis l'api
     */
    companion object {
        // operator fun invoke() permet d'appeler directement de faire ApixuWeatherApiService()
        // si il n'y avait que fun create()
        // par exemple il faudrait faire l'appel -> ApixuWeatherApiService.create()
        operator fun invoke() : ApixuWeatherApiService {
            // mettre la clé d'api à chaque appel du service
            // Interceptor -> classe anonyme donc lambda qui passe une chain qui intercepte la requête
            val requestInterceptor = Interceptor { chain ->

                val url : HttpUrl = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()

                val request : Request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            // contient l'interceptor
            val okHttpClient : OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)

        }
    }
}