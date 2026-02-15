package com.apptitudine.meteoportfolio
import WeatherService
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {


    private val API_KEY = "YOUR_API_KEY_HERE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSearch = findViewById<ImageButton>(R.id.btnSearch)
        val editCity = findViewById<EditText>(R.id.editCity)
        val txtTemp = findViewById<TextView>(R.id.txtTemp)
        val txtCityName = findViewById<TextView>(R.id.txtCityName)
        val txtDesc = findViewById<TextView>(R.id.txtDesc)

        btnSearch.setOnClickListener {
            val city = editCity.text.toString()
            if (city.isNotEmpty()) {
                fetchWeatherData(city, txtTemp, txtCityName, txtDesc)
            }
        }
    }

    private fun fetchWeatherData(city: String, t: TextView, c: TextView, d: TextView) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(WeatherService::class.java)

        // Usiamo le Coroutine per non bloccare l'interfaccia
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.getWeather(city, API_KEY)
                withContext(Dispatchers.Main) {
                    t.text = "${response.main.temp.toInt()}°C"
                    c.text = response.name
                    d.text = response.weather[0].description.capitalize()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    d.text = "Errore: città non trovata"
                }
            }
        }
    }
}