package com.example.splash

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController

class SplashActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        navController = findNavController(R.id.nav_host_intro)

        timer = object : CountDownTimer(5000, 1) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                navToMatches()
            }
        }
        timer.start()
    }

    fun navToMatches() =
        navController.navigate(R.id.action_splashFragment_to_nav_matches_graph)

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}