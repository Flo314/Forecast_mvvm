package com.example.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

/**
 * @ColumnInfo dire quel est le nom du champ dans la base de donnée
 * sert à obtenir les données stockés dans la DB
 */
data class ImperialCurrentWeatherEntry(
    @ColumnInfo(name= "temperature")
    override val temperature: Double,
    @ColumnInfo(name= "weatherDescriptions")
    override val conditionText: String,
    @ColumnInfo(name= "weatherIcons")
    override val conditionIconUrl: String,
    @ColumnInfo(name= "windSpeed")
    override val windSpeed: Double,
    @ColumnInfo(name= "windDir")
    override val windDirection: String,
    @ColumnInfo(name= "precip")
    override val precipitationVolume: Double,
    @ColumnInfo(name= "feelslike")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name= "visibility")
    override val visibilityDistance: Double
): UnitSpecificCurrentWeatherEntry {
}