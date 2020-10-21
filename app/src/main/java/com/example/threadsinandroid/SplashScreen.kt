package com.example.threadsinandroid

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.widget.TextView
import android.widget.Toast

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
          var handler: Handler
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


//        //Simple thread example
//
//
//        //val mediaPlayer:MediaPlayer
//        val th = Thread(){
//
//
//            kotlin.run {
//                val mediaPlayer = MediaPlayer.create(this , R.raw.mymusic)
//                mediaPlayer.start()
//                Thread.sleep(5000)
//                mediaPlayer.stop()
//                var intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//            }
//        }
//        th.start()

        //Thread example to post data to UI using handler.post()
        handler = Handler()
        val th = Thread(){

            kotlin.run {
                var counter = 0
                val mediaPlayer = MediaPlayer.create(this , R.raw.mymusic)
                mediaPlayer.start()
                for(i in 1..5){
                    Thread.sleep(1000)
                    counter++
                    handler.post{
                         var c: TextView = findViewById(R.id.text_view_counter)
                        c.setText("" + counter)
                    }
                    runOnUiThread{
                        Toast.makeText(this , "On Main Thread", Toast.LENGTH_SHORT).show()
                    }

                }

                mediaPlayer.stop()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        th.start()
    }
}