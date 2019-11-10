package com.example.forecastmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.forecastmvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // controller de navigation
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // navigation de l'application
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        // configuration de la bottom_nav *Menu*
        bottom_nav.setupWithNavController(navController)
        // configuration de actionbar
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    /**
     * Permet de mettre en place la flèche de retour au Fragment ou activité de départ
     */
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}
