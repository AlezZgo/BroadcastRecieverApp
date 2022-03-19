package com.example.broadcastrecieverapp

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.broadcastrecieverapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val myBroadcastReceiver: BroadcastReceiver = MyRegisteredByCodeBroadcastReceiver()

    private val myLocalBroadcastReceiver: BroadcastReceiver = MyLocalBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        val intentFilter = IntentFilter("MY_ACTION")
        this.registerReceiver(myBroadcastReceiver,intentFilter)

        LocalBroadcastManager.getInstance(this)
            .registerReceiver(myLocalBroadcastReceiver, IntentFilter("MY_LOCAL_ACTION"))

        binding.button.setOnClickListener {
            val intent = Intent()
            intent.action = "com.example.broadcast.MY_NOTIFICATION"
            intent.putExtra("data", "Hello World!")
            sendBroadcast(intent)
        }

        binding.buttonBcrWithReg.setOnClickListener {
            val intent = Intent("MY_ACTION")
            intent.putExtra("data", "from registered from code!")
            sendBroadcast(intent)
        }

        binding.buttonBcrLocal.setOnClickListener {
            val intent = Intent("MY_LOCAL_ACTION")
            intent.putExtra("data", "Hello local World!")
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }

        setContentView(binding.root)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(myBroadcastReceiver)
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcastReceiver)
    }

}