package com.apptitudine.meteoportfolio

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>,
    val name: String // Nome della città
)

data class Main(
    val temp: Double // Temperatura
)

data class Weather(
    val description: String // Esempio: "cielo sereno"
)