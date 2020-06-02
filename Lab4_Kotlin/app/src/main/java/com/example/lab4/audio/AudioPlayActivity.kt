package com.example.lab4.audio

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab4.R
import kotlinx.android.synthetic.main.activity_audio_play.*


class AudioPlayActivity() : AppCompatActivity() {

    private var mPlayer : MediaPlayer = MediaPlayer()
    private lateinit var runnable : Runnable
    private var handler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_play)

        val arguments: Bundle? = intent.extras
        val audioId = arguments?.get("chosenId")

        val actionBar = supportActionBar
        actionBar!!.title = arguments?.get("chosenName").toString()

        val myUri = Uri.parse("android.resource://$packageName/$audioId")
        mPlayer = MediaPlayer().apply {
            setDataSource(this@AudioPlayActivity, myUri)
            prepare()
            start()
        }

        initializeSeekBar()

        audioSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    mPlayer.seekTo(progress * 1000)

                    Toast.makeText(
                        this@AudioPlayActivity,
                        (mPlayer.currentPosition / 1000 / 60).toString() + " min, " +
                                (mPlayer.currentPosition / 1000 % 60).toString() + " sec",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) { }

            override fun onStopTrackingTouch(seekBar: SeekBar?) { }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun initializeSeekBar() {
        audioSeekBar.max = mPlayer.duration / 1000
        showTime.text = ""
        showTime.append((mPlayer.duration / 1000 / 60).toString() + " min, " +
                (mPlayer.duration / 1000 % 60).toString() + " sec")

        runnable = Runnable {
            audioSeekBar.progress = mPlayer.currentPosition / 1000
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }

    fun onPlay(view: View){
        mPlayer.start()
    }

    fun onPause(view: View){
        mPlayer.pause()
    }

    fun onStop(view: View){
        mPlayer.stop()
        finish()
    }
}