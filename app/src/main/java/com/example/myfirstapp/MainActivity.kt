package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import com.example.myfirstapp.R.menu.bottom_navigation_menu
import com.google.android.material.bottomnavigation.BottomNavigationView

const val TAG = "MyTag"

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationMenu: BottomNavigationView
    lateinit var transaction: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, Fragment1()).addToBackStack("fragment1")
        transaction.commit()
        bottomNavigationMenu = findViewById(R.id.bottom_navigation)
        bottomNavigationMenu.setOnItemSelectedListener { item ->
            showFragment(item)
            true
        }
    }


    fun showFragment(item: MenuItem) {
        transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.fragment_1 -> {
                Log.d(TAG, "showFragment1")
                transaction.replace(R.id.fragmentContainerView, Fragment1()).addToBackStack("fragment1")
                transaction.commit()
            }
            R.id.fragment_2 -> {
                Log.d(TAG, "showFragment2")
                transaction.replace(R.id.fragmentContainerView, Fragment2()).addToBackStack("fragment2")
                transaction.commit()
            }
            else -> false
        }
        true
    }
}


