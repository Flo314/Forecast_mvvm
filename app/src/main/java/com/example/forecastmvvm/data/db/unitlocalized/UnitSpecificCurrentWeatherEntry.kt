package com.example.forecastmvvm.data.db.unitlocalized

/**
 * utiliser uniquement dans le but de récupérer le champ approprié
 * et pour que le nom des champs soient plus clairs
 * ex precip = precipitationVolume
 */
interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val conditionText: String
    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double

}