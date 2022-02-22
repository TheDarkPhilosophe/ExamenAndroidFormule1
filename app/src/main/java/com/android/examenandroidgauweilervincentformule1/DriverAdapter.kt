package com.android.examenandroidgauweilervincentformule1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DriverAdapter(drivers: List<DriverTeam>) : RecyclerView.Adapter<DriverAdapter.ViewHolder>() {
    val listedrivers: List<DriverTeam> = drivers
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nomView: TextView= itemView.findViewById(R.id.nom)
        val equipeView : TextView= itemView.findViewById(R.id.nom)
        val pointsView : TextView= itemView.findViewById(R.id.points)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context : Context = parent.context
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val driverview = inflater.inflate(R.layout.objet_driver, parent, false)
        return ViewHolder(driverview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val driver : DriverTeam=listedrivers.get(position)
        var nomTextDriver= holder.nomView
        nomTextDriver.setText(driver.driver.name)
        var equipeTextView= holder.equipeView
        equipeTextView.setText(driver.team.name)
        var pointsTextView =holder.pointsView
        pointsTextView.setText(driver.points+" points")
    }

    override fun getItemCount(): Int {
        return listedrivers.size
    }
}