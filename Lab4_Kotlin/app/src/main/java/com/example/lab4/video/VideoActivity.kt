package com.example.lab4.video

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.lab4.R
import com.example.lab4.audio.Audio

class VideoActivity : AppCompatActivity() {

    private lateinit var chosen:Video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val actionBar = supportActionBar
        actionBar!!.title = "Videos"

        val spinner = findViewById<Spinner>(R.id.videoSpinner)

        val videoList = resources.getStringArray(R.array.videos)
        val videoUrlList = resources.getStringArray(R.array.videoUrls)

        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, videoList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val videos = listOf(
                    Video(videoUrlList[0], videoList[0]),
                    Video(videoUrlList[1],videoList[1])
                )
                Toast.makeText(
                    this@VideoActivity,
                    "Chosen ${videos[position].name}",
                    Toast.LENGTH_SHORT
                ).show()
                chosen = videos[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) { }

        }
    }
    fun onClicked(view: View){
        val intent = Intent(this, VideoPlayActivity::class.java)
        intent.putExtra("chosenUrl",chosen.url)
        intent.putExtra("chosenName", chosen.name)
        startActivity(intent)
    }
}
