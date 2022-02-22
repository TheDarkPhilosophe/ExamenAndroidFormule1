package com.android.examenandroidgauweilervincentformule1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface DriverService {
    companion object {
        val ENDPOINT = "https://busin.fr/"
    }

    @GET("/driver.json")
    fun listDrivers(): Call<List<DriverTeam>>

    //@GET("driver/{driverId}")
    //fun getDriverById(@Path("driverId") driverId: Int): Observable<Driver>
}