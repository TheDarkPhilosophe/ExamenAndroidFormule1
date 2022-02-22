package com.android.examenandroidgauweilervincentformule1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {
    private val liste: ArrayList<Driver> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = Retrofit.Builder()
            .baseUrl(DriverService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DriverService::class.java)

        service.listDrivers().enqueue(object : Callback<List<DriverTeam>> {
            override fun onResponse(call: Call<List<DriverTeam>>, response: Response<List<DriverTeam>>) {
                afficherDriver(response.body())
            }

            override fun onFailure(call: Call<List<DriverTeam>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    fun afficherDriver(drivers: List<DriverTeam?>?) {
        if (drivers!=null){
            Toast.makeText(this,"Nombre de driver : "+ drivers.size, Toast.LENGTH_SHORT).show()
            var driverListe : MutableList<DriverTeam> = ArrayList<DriverTeam>()
            val recyclerDriver : RecyclerView = findViewById(R.id.RecyclerDrivers)
            for(driver in drivers)
            {driverListe.add(driver)}
            val adapter : DriverAdapter= DriverAdapter(drivers)
            recyclerDriver.setAdapter(adapter)
            recyclerDriver.setLayoutManager(LinearLayoutManager(this))
        }
    }
}