package com.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.numberguessinggame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

 val navHostFragment= supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment //xml main activity dosyasındaki container ı tanımladık.
 NavigationUI.setupWithNavController(binding.bottomNavigationView, navHostFragment.navController) //menu kısmını bağladık


    }
}