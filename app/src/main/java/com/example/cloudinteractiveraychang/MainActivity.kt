package com.example.cloudinteractiveraychang

import android.app.AlertDialog
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var fragmentId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavController()
    }

    private fun setupNavController() {
        findNavController(R.id.myNavHostFragment).addOnDestinationChangedListener { navController: NavController, _: NavDestination, _: Bundle? ->
            fragmentId = when (navController.currentDestination?.id) {
                R.id.homeFragment -> R.id.homeFragment
                else -> 0
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            when (fragmentId) {
                R.id.homeFragment -> dialog()
                else -> findNavController(R.id.myNavHostFragment).navigateUp()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun dialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("注意")
            .setMessage("是否要離開 APP ?")
            .setPositiveButton("OK") { dialog, _ ->
                exitApp()
                dialog.dismiss()
            }
            .setNeutralButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        runOnUiThread { dialog.show() }
    }

    private fun exitApp() {
        finish()
        exitProcess(0)
    }
}
