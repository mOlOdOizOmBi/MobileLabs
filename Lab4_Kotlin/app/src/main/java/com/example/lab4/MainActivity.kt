package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lab4.audio.AudioActivity
import com.example.lab4.video.VideoActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title = "Lab 4 - Main"
    }
    fun onVideoClicked(view: View){
        val intent = Intent(this, VideoActivity::class.java)
        startActivity(intent);
    }
    fun onAudioClicked(view: View){
        val intent = Intent(this, AudioActivity::class.java)
        startActivity(intent);
    }
}
