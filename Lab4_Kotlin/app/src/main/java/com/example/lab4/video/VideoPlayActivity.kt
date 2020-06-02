package com.example.lab4.video

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.example.lab4.R
import kotlinx.android.synthetic.main.activity_video_play.*

class VideoPlayActivity : AppCompatActivity() {

    private lateinit var vPlayer: MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play)

        val arguments: Bundle? = intent.extras
        val videoUrl = arguments?.get("chosenUrl").toString()

        val actionBar = supportActionBar
        actionBar!!.title = arguments?.get("chosenName").toString()

        vPlayer = MediaController(this)
        videoPlayer.setMediaController(vPlayer)
        videoPlayer.setVideoPath(videoUrl)
        videoPlayer.start()
    }
    fun play(view: View){
        videoPlayer.start()
    }
    fun pause(view: View){
        videoPlayer.pause()
    }
    fun stop(view: View){
        videoPlayer.stopPlayback()
        finish()
    }
}
