import com.apptitudine.meteoportfolio.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric", // Celsius
        @Query("lang") lang: String = "it"        // Italiano
    ): WeatherResponse
}