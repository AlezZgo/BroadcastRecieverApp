package com.example.broadcastrecieverapp

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.broadcastrecieverapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button.setOnClickListener {

                val intent = Intent()
                intent.action = "com.example.broadcast.MY_NOTIFICATION"
                intent.putExtra("data", "Hello World!")
                sendBroadcast(intent)
            }

        setContentView(binding.root)
    }

}