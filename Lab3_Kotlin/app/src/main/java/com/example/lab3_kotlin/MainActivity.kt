package com.example.lab3_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MainFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(result: String) {
        var fragment = supportFragmentManager.findFragmentById(R.id.resultFragment) as ResultFragment
        var fragment2 = supportFragmentManager.findFragmentById(R.id.fileFragment) as FileFragment
        if(fragment.isInLayout){
            fragment.setText(result)
        }
        if(fragment2.isInLayout){
            fragment2.setCurrentResult(result)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
