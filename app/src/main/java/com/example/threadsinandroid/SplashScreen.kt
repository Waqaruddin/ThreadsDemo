package com.example.threadsinandroid

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //val mediaPlayer:MediaPlayer
        val th = Thread(){


            kotlin.run {
                val mediaPlayer = MediaPlayer.create(this , R.raw.mymusic)
                mediaPlayer.start()
                Thread.sleep(5000)
                mediaPlayer.stop()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        th.start()
    }
}